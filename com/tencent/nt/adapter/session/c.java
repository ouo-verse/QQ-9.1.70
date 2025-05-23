package com.tencent.nt.adapter.session;

import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0002H\u0007JR\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0007JR\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\fH\u0002JR\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u000228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\fH\u0007JR\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u000228\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0017\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00120\fH\u0002R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/nt/adapter/session/c;", "", "", "uinType", "l", "chatType", "c", "", "e", "d", "", "uin", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "Lcom/tencent/nt/adapter/session/e;", "sessionWithUid", "", "callback", "j", "f", "uid", "Lcom/tencent/nt/adapter/session/f;", "sessionWithUin", tl.h.F, "g", "Landroid/util/ArrayMap;", "b", "Landroid/util/ArrayMap;", "c2u", "u2c", "", "Ljava/util/Set;", "needConvertUinType", "needConvertChatType", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f339128a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayMap<Integer, Integer> c2u;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayMap<Integer, Integer> u2c;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<Integer> needConvertUinType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<Integer> needConvertChatType;

    static {
        Set<Integer> of5;
        Set<Integer> of6;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f339128a = new c();
        ArrayMap<Integer, Integer> arrayMap = new ArrayMap<>();
        arrayMap.put(1, 0);
        arrayMap.put(2, 1);
        arrayMap.put(3, 3000);
        arrayMap.put(100, 1000);
        arrayMap.put(4, 10014);
        arrayMap.put(103, 1008);
        arrayMap.put(106, 1001);
        arrayMap.put(104, 1046);
        arrayMap.put(111, 1006);
        arrayMap.put(102, 1025);
        arrayMap.put(105, 10007);
        arrayMap.put(101, 1022);
        arrayMap.put(113, 10008);
        arrayMap.put(117, 1005);
        arrayMap.put(115, 10019);
        arrayMap.put(118, 10022);
        arrayMap.put(8, 6000);
        c2u = arrayMap;
        ArrayMap<Integer, Integer> arrayMap2 = new ArrayMap<>();
        Set<Integer> keySet = arrayMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "c2u.keys");
        for (Integer num : keySet) {
            arrayMap2.put(c2u.get(num), num);
        }
        arrayMap2.put(1024, 102);
        arrayMap2.put(1005, 117);
        arrayMap2.put(1043, 1);
        arrayMap2.put(10008, 113);
        arrayMap2.put(6005, 8);
        arrayMap2.put(6000, 8);
        arrayMap2.put(6003, 8);
        u2c = arrayMap2;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{0, 1000, 1008, 1025, 1024, 1005, 1022, 10007, 10019, 10022, 1043, 10008});
        needConvertUinType = of5;
        of6 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 100, 103, 102, 117, 101, 115});
        needConvertChatType = of6;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int c(int chatType) {
        Integer num = c2u.get(Integer.valueOf(chatType));
        if (num == null) {
            return 10021;
        }
        return num.intValue();
    }

    @JvmStatic
    public static final boolean d(int chatType) {
        return needConvertChatType.contains(Integer.valueOf(chatType));
    }

    @JvmStatic
    public static final boolean e(int uinType) {
        return needConvertUinType.contains(Integer.valueOf(uinType));
    }

    private final void f(String uin, int chatType, Function2<? super Boolean, ? super e, Unit> callback) {
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        if (TextUtils.isEmpty(uidFromUin)) {
            callback.invoke(Boolean.FALSE, null);
            return;
        }
        Boolean bool = Boolean.TRUE;
        Intrinsics.checkNotNull(uidFromUin);
        callback.invoke(bool, new e(uidFromUin, chatType));
    }

    private final void g(String uid, int uinType, Function2<? super Boolean, ? super f, Unit> callback) {
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(uid);
        if (TextUtils.isEmpty(uinFromUid)) {
            callback.invoke(Boolean.FALSE, null);
            return;
        }
        Boolean bool = Boolean.TRUE;
        Intrinsics.checkNotNull(uinFromUid);
        callback.invoke(bool, new f(uinFromUid, uinType));
    }

    @JvmStatic
    public static final void h(@NotNull final String uid, int chatType, @NotNull final Function2<? super Boolean, ? super f, Unit> callback) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final int c16 = c(chatType);
        if (c16 == 10021) {
            callback.invoke(Boolean.FALSE, null);
            return;
        }
        if (!d(chatType)) {
            callback.invoke(Boolean.TRUE, new f(uid, c16));
        } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.nt.adapter.session.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.i(uid, c16, callback);
                }
            }, 16, null, false);
        } else {
            f339128a.g(uid, c16, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String uid, int i3, Function2 callback) {
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        f339128a.g(uid, i3, callback);
    }

    @JvmStatic
    public static final void j(@NotNull final String uin, int uinType, @NotNull final Function2<? super Boolean, ? super e, Unit> callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final int l3 = l(uinType);
        if (l3 == 0) {
            QLog.d("SessionConverterUtils", 1, "uin2Uid unSupport. uinType=" + uinType);
            callback.invoke(Boolean.FALSE, null);
            return;
        }
        if (!e(uinType)) {
            callback.invoke(Boolean.TRUE, new e(uin, l3));
        } else if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.nt.adapter.session.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.k(uin, l3, callback);
                }
            }, 16, null, false);
        } else {
            f339128a.f(uin, l3, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String uin, int i3, Function2 callback) {
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        f339128a.f(uin, i3, callback);
    }

    @JvmStatic
    public static final int l(int uinType) {
        Integer num = u2c.get(Integer.valueOf(uinType));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }
}
