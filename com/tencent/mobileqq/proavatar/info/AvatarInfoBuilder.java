package com.tencent.mobileqq.proavatar.info;

import android.net.Uri;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.proavatar.bean.ZPlanOutboundAvatarInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.meta.info.e;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b'\u0010(J3\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJW\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JW\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\rH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0010J0\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J$\u0010!\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d0\u001f2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J9\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\bH\u0016\u00a2\u0006\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/AvatarInfoBuilder;", "Lcom/tencent/qqnt/avatar/meta/info/e;", "Lcom/tencent/qqnt/avatar/meta/a;", "avatarBean", "", "", "", "map", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "d", "(Lcom/tencent/qqnt/avatar/meta/a;Ljava/util/Map;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extra", "g", "(Lcom/tencent/qqnt/avatar/meta/a;Ljava/util/Map;Ljava/util/HashMap;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "e", "", "target", "", "c", "url", "", "time", "f", "bean", "", FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG, "", "i", "Lkotlin/Pair;", "", h.F, "size", "j", "mapArr", "a", "(Lcom/tencent/qqnt/avatar/meta/a;[Ljava/util/Map;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvatarInfoBuilder implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<Boolean> f259615b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/proavatar/info/AvatarInfoBuilder$a;", "", "", "troopAvatarUrlSizeFixSwitch$delegate", "Lkotlin/Lazy;", "b", "()Z", "troopAvatarUrlSizeFixSwitch", "", "APNG_FACE_FLAG", "Ljava/lang/String;", "AVATAR_TYPE", "FACE_FLAG", "HEAD_IMG_TIMESTAMP", "INFO_REQUEST_TIME", "STATIC_ZPLAN_FACE_FLAG", "TAG", NowProxyConstants.AccountInfoKey.UID, Global.TRACKING_URL, "ZPLAN_FACE_BG_URL", "ZPLAN_FACE_CLIP_PERCENT", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.info.AvatarInfoBuilder$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b() {
            return ((Boolean) AvatarInfoBuilder.f259615b.getValue()).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        Lazy<Boolean> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(AvatarInfoBuilder$Companion$troopAvatarUrlSizeFixSwitch$2.INSTANCE);
        f259615b = lazy;
    }

    public AvatarInfoBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c(Map<String, ? extends Object> map, Map<String, Object> target) {
        Object obj = map.get("uin");
        if (obj == null) {
            obj = "";
        }
        target.put("uin", obj);
        Object obj2 = map.get("avatar_type");
        if (obj2 == null) {
            obj2 = 0;
        }
        target.put("avatar_type", obj2);
        Object obj3 = map.get(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP);
        if (obj3 == null) {
            obj3 = 0L;
        }
        target.put(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP, obj3);
    }

    private final com.tencent.qqnt.avatar.meta.info.a[] d(com.tencent.qqnt.avatar.meta.a avatarBean, Map<String, ? extends Object> map) {
        Long l3;
        long j3;
        Long l16;
        Byte b16;
        byte b17;
        Byte b18;
        byte b19;
        Byte b26;
        byte b27;
        Integer num;
        int i3;
        if (map.isEmpty()) {
            return null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        c(map, hashMap);
        com.tencent.qqnt.avatar.meta.info.a[] g16 = g(avatarBean, map, hashMap);
        if (g16 != null) {
            return g16;
        }
        com.tencent.qqnt.avatar.meta.info.a[] e16 = e(avatarBean, map, hashMap);
        if (e16 != null) {
            return e16;
        }
        Object obj = map.get(FaceConstant.AvatarInfoBuilderKeys.HEAD_IMG_TIMESTAMP);
        if (obj instanceof Long) {
            l3 = (Long) obj;
        } else {
            l3 = null;
        }
        long j16 = 0;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        Object obj2 = map.get(FaceConstant.AvatarInfoBuilderKeys.INFO_REQUEST_TIME);
        if (obj2 instanceof Long) {
            l16 = (Long) obj2;
        } else {
            l16 = null;
        }
        if (l16 != null) {
            j16 = l16.longValue();
        }
        long j17 = j16;
        if (avatarBean.a() == 1) {
            boolean f16 = avatarBean.f(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, false);
            boolean z16 = avatarBean instanceof com.tencent.qqnt.avatar.dynamic.a;
            Object obj3 = map.get(FaceConstant.AvatarInfoBuilderKeys.STATIC_ZPLAN_FACE_FLAG);
            if (obj3 instanceof Byte) {
                b18 = (Byte) obj3;
            } else {
                b18 = null;
            }
            if (b18 != null) {
                b19 = b18.byteValue();
            } else {
                b19 = 0;
            }
            Object obj4 = map.get(FaceConstant.AvatarInfoBuilderKeys.APNG_FACE_FLAG);
            if (obj4 instanceof Byte) {
                b26 = (Byte) obj4;
            } else {
                b26 = null;
            }
            if (b26 != null) {
                b27 = b26.byteValue();
            } else {
                b27 = 0;
            }
            if (f16 && b19 > 0) {
                hashMap.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
                Object obj5 = map.get(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_CLIP_PERCENT);
                if (obj5 instanceof Integer) {
                    num = (Integer) obj5;
                } else {
                    num = null;
                }
                if (num != null) {
                    i3 = num.intValue();
                } else {
                    i3 = 0;
                }
                hashMap.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_CLIP_PERCENT, Integer.valueOf(i3));
                Object obj6 = map.get(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL);
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.String");
                hashMap.put(FaceConstant.ZPLAN_OUT_BOUND_BG_URL, (String) obj6);
                String h16 = avatarBean.h();
                Object obj7 = map.get("url");
                int j18 = j(avatarBean.e(), b19);
                String str = avatarBean.h() + "_zplanBg";
                Object obj8 = map.get(FaceConstant.AvatarInfoBuilderKeys.ZPLAN_FACE_BG_URL);
                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.String");
                return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(h16, f(obj7 + j18 + "sz", j3), j17, hashMap), new com.tencent.qqnt.avatar.meta.info.a(str, (String) obj8, 0L, null, 12, null)};
            }
            if (z16 && b27 > 0) {
                com.tencent.qqnt.avatar.meta.info.a aVar = new com.tencent.qqnt.avatar.meta.info.a(avatarBean.h(), f(map.get("url") + j(avatarBean.e(), b27) + "a", j3), j17, hashMap);
                aVar.f(true);
                aVar.g("apng");
                return new com.tencent.qqnt.avatar.meta.info.a[]{aVar};
            }
        }
        Object obj9 = map.get(FaceConstant.AvatarInfoBuilderKeys.FACE_FLAG);
        if (obj9 instanceof Byte) {
            b16 = (Byte) obj9;
        } else {
            b16 = null;
        }
        if (b16 != null) {
            b17 = b16.byteValue();
        } else {
            b17 = 0;
        }
        String h17 = avatarBean.h();
        Object obj10 = map.get("url");
        int i16 = i(avatarBean, b17);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj10);
        sb5.append(i16);
        return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(h17, f(sb5.toString(), j3), j17, hashMap)};
    }

    private final com.tencent.qqnt.avatar.meta.info.a[] e(com.tencent.qqnt.avatar.meta.a avatarBean, Map<String, ? extends Object> map, HashMap<String, Object> extra) {
        Uri uri;
        Object obj = map.get("avatar_info_uri");
        if (obj instanceof Uri) {
            uri = (Uri) obj;
        } else {
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        String d16 = avatarBean.d();
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(d16, uri2, 0L, extra, 4, null)};
    }

    private final String f(String url, long time) {
        boolean contains$default;
        String str;
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = "&t=" + time;
        } else {
            str = "?t=" + time;
        }
        return url + str;
    }

    private final com.tencent.qqnt.avatar.meta.info.a[] g(com.tencent.qqnt.avatar.meta.a avatarBean, Map<String, ? extends Object> map, HashMap<String, Object> extra) {
        ZPlanOutboundAvatarInfo zPlanOutboundAvatarInfo;
        String a16;
        String b16;
        Object obj = map.get("zplan_outbound_avatar_info");
        if (!(obj instanceof ZPlanOutboundAvatarInfo) || (a16 = (zPlanOutboundAvatarInfo = (ZPlanOutboundAvatarInfo) obj).a()) == null || (b16 = zPlanOutboundAvatarInfo.b()) == null) {
            return null;
        }
        extra.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
        extra.put(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_CLIP_PERCENT, Integer.valueOf(zPlanOutboundAvatarInfo.f()));
        extra.put(FaceConstant.ZPLAN_OUT_BOUND_BG_URL, b16);
        return new com.tencent.qqnt.avatar.meta.info.a[]{new com.tencent.qqnt.avatar.meta.info.a(avatarBean.d(), a16, 0L, extra, 4, null), new com.tencent.qqnt.avatar.meta.info.a(avatarBean.d() + "_zplanBg", b16, 0L, null, 12, null)};
    }

    private final Pair<Boolean, Integer> h(com.tencent.qqnt.avatar.meta.a bean, byte faceFlag) {
        if (!INSTANCE.b()) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        if (bean.a() != 4 && bean.a() != 8) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        if (bean.e() > 100 && faceFlag <= 4) {
            return new Pair<>(Boolean.TRUE, 0);
        }
        return new Pair<>(Boolean.FALSE, 0);
    }

    private final int i(com.tencent.qqnt.avatar.meta.a bean, byte faceFlag) {
        Pair<Boolean, Integer> h16 = h(bean, faceFlag);
        if (h16.getFirst().booleanValue()) {
            return h16.getSecond().intValue();
        }
        int e16 = bean.e();
        int i3 = 140;
        if (e16 != 0 && e16 != 100 && e16 != 140 && (e16 == 200 || e16 == 640)) {
            i3 = 640;
        }
        return AvatarDownloadUtil.getQQHeadImageSize(faceFlag, i3);
    }

    private final int j(int size, byte faceFlag) {
        if (faceFlag <= 0) {
            return 140;
        }
        return AvatarDownloadUtil.getZplanAvatarUrlSize(size, faceFlag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.avatar.meta.info.e
    @Nullable
    public com.tencent.qqnt.avatar.meta.info.a[] a(@NotNull com.tencent.qqnt.avatar.meta.a avatarBean, @NotNull Map<String, Object>[] mapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) avatarBean, (Object) mapArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        Intrinsics.checkNotNullParameter(mapArr, "mapArr");
        if (mapArr.length == 1) {
            return d(avatarBean, mapArr[0]);
        }
        int length = mapArr.length;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr = new com.tencent.qqnt.avatar.meta.info.a[length];
        for (int i3 = 0; i3 < length; i3++) {
            aVarArr[i3] = new com.tencent.qqnt.avatar.meta.info.a("", "", 0L, null, 12, null);
        }
        int length2 = mapArr.length;
        for (int i16 = 0; i16 < length2; i16++) {
            com.tencent.qqnt.avatar.meta.info.a[] d16 = d(avatarBean, mapArr[i16]);
            if (d16 == null) {
                return null;
            }
            aVarArr[i16] = d16[0];
        }
        return aVarArr;
    }
}
