package com.tencent.mobileqq.zplan.friend;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004J,\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016R:\u0010\u0013\u001a(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u00100\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendAvatarUtil;", "Lcom/tencent/mobileqq/avatar/listener/DecodeTaskCompletionListener;", "", "uin", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "callback", "a", "", "remainingTasks", "type", "avatar", "onDecodeTaskCompleted", "", "", "Lmqq/util/WeakReference;", "e", "Ljava/util/Map;", "pendingReq", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "f", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/app/face/IFaceDecoder;", "faceDecoder", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendAvatarUtil implements DecodeTaskCompletionListener {

    /* renamed from: d, reason: collision with root package name */
    public static final ZPlanFriendAvatarUtil f333661d = new ZPlanFriendAvatarUtil();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<WeakReference<Function1<Bitmap, Unit>>>> pendingReq = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy faceDecoder;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IFaceDecoder>() { // from class: com.tencent.mobileqq.zplan.friend.ZPlanFriendAvatarUtil$faceDecoder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFaceDecoder invoke() {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                AppInterface appInterface = (AppInterface) waitAppRuntime;
                IFaceDecoder iQQAvatarService = ((IQQAvatarService) appInterface.getRuntimeService(IQQAvatarService.class, "all")).getInstance(appInterface);
                iQQAvatarService.setDecodeTaskCompletionListener(ZPlanFriendAvatarUtil.f333661d);
                return iQQAvatarService;
            }
        });
        faceDecoder = lazy;
    }

    ZPlanFriendAvatarUtil() {
    }

    private final IFaceDecoder b() {
        Object value = faceDecoder.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-faceDecoder>(...)");
        return (IFaceDecoder) value;
    }

    public final void a(String uin, Function1<? super Bitmap, Unit> callback) {
        List<WeakReference<Function1<Bitmap, Unit>>> mutableListOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Bitmap bitmapFromCache = b().getBitmapFromCache(1, uin);
        if (bitmapFromCache != null) {
            callback.invoke(bitmapFromCache);
            return;
        }
        Map<String, List<WeakReference<Function1<Bitmap, Unit>>>> map = pendingReq;
        if (map.get(uin) == null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WeakReference(callback));
            map.put(uin, mutableListOf);
        } else {
            List<WeakReference<Function1<Bitmap, Unit>>> list = map.get(uin);
            Intrinsics.checkNotNull(list, "null cannot be cast to non-null type kotlin.collections.MutableList<mqq.util.WeakReference<kotlin.Function1<android.graphics.Bitmap?, kotlin.Unit>>>");
            TypeIntrinsics.asMutableList(list).add(new WeakReference(callback));
        }
        QLog.i("ZPlanFriendAvatarUtil", 1, "get avatar uin " + uin);
        b().requestDecodeFace(uin, 1, true);
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int remainingTasks, int type, String uin, Bitmap avatar) {
        List<WeakReference<Function1<Bitmap, Unit>>> remove;
        QLog.i("ZPlanFriendAvatarUtil", 1, "onDecodeTaskCompleted " + uin);
        if (uin == null || (remove = pendingReq.remove(uin)) == null) {
            return;
        }
        Iterator<T> it = remove.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) ((WeakReference) it.next()).get();
            if (function1 != null) {
                function1.invoke(avatar);
            }
            QLog.i("ZPlanFriendAvatarUtil", 1, "invoke callback " + uin);
        }
    }
}
