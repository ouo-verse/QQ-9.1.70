package com.tencent.mobileqq.mutualmark.nt;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00002\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0000J&\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004R&\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/g;", "", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip$LocalGrayTipBuilder;", "builder", "", "wording", "", "a", "Lcom/tencent/mobileqq/mutualmark/d$b;", "info", "b", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "url", "e", "d", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "uin", "", "grayId", "c", "Ljava/util/ArrayList;", "highLightInfoList", "Ljava/lang/String;", "commonUrl", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<d.b> highLightInfoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String commonUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/g$a;", "", "Lcom/tencent/mobileqq/mutualmark/nt/g;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.mutualmark.nt.g$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final g a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (g) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new g();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((d.b) t16).f252025e), Integer.valueOf(((d.b) t17).f252025e));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.highLightInfoList = new ArrayList<>();
            this.commonUrl = "";
        }
    }

    private final void a(LocalGrayTip.LocalGrayTipBuilder builder, String wording) {
        boolean z16;
        boolean z17;
        if (this.highLightInfoList.size() > 0) {
            if (wording.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                builder.g(wording.subSequence(0, this.highLightInfoList.get(0).f252025e).toString(), 1);
                Iterator<d.b> it = this.highLightInfoList.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    int i16 = i3 + 1;
                    d.b next = it.next();
                    if (i3 > 0 && i3 < this.highLightInfoList.size()) {
                        String obj = wording.subSequence(this.highLightInfoList.get(i3 - 1).f252026f, this.highLightInfoList.get(i3).f252025e).toString();
                        if (obj.length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            builder.g(obj, 1);
                        }
                    }
                    b(next, builder);
                    i3 = i16;
                }
                ArrayList<d.b> arrayList = this.highLightInfoList;
                builder.g(wording.subSequence(arrayList.get(arrayList.size() - 1).f252026f, wording.length()).toString(), 1);
            }
        }
    }

    private final void b(d.b info, LocalGrayTip.LocalGrayTipBuilder builder) {
        switch (info.f252021a) {
            case 1:
                String str = info.f252027g;
                Intrinsics.checkNotNullExpressionValue(str, "info.key");
                builder.a(str, this.commonUrl, 3);
                return;
            case 2:
                String keyV2 = com.tencent.mobileqq.mutualmark.g.r(info.f252027g);
                Intrinsics.checkNotNullExpressionValue(keyV2, "keyV2");
                LocalGrayTip.LocalGrayTipBuilder.d(builder, keyV2, null, null, 6, null);
                return;
            case 3:
                String str2 = info.f252027g;
                Intrinsics.checkNotNullExpressionValue(str2, "info.key");
                String str3 = info.f252028h;
                Intrinsics.checkNotNullExpressionValue(str3, "info.url");
                builder.a(str2, str3, 3);
                return;
            case 4:
                String urlV2 = com.tencent.mobileqq.mutualmark.g.r(info.f252028h);
                Intrinsics.checkNotNullExpressionValue(urlV2, "urlV2");
                LocalGrayTip.LocalGrayTipBuilder.d(builder, urlV2, null, null, 6, null);
                return;
            case 5:
                String str4 = info.f252027g;
                Intrinsics.checkNotNullExpressionValue(str4, "info.key");
                builder.g(str4, 3);
                return;
            case 6:
                IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
                String str5 = info.f252024d;
                if (str5 == null) {
                    str5 = "";
                }
                com.tencent.qqnt.graytips.action.f actionInfo = iMutualMarkHelperApi.createSpecialCareActionInfo(str5);
                String str6 = info.f252027g;
                Intrinsics.checkNotNullExpressionValue(str6, "info.key");
                Intrinsics.checkNotNullExpressionValue(actionInfo, "actionInfo");
                builder.h(str6, actionInfo, 3);
                return;
            case 7:
                String str7 = info.f252027g;
                Intrinsics.checkNotNullExpressionValue(str7, "info.key");
                String str8 = info.f252028h;
                Intrinsics.checkNotNullExpressionValue(str8, "info.url");
                builder.e(str7, str8, 3);
                return;
            default:
                return;
        }
    }

    public final void c(@NotNull QQAppInterface app, @NotNull String uin, int grayId, @NotNull String wording) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, uin, Integer.valueOf(grayId), wording);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(wording, "wording");
        if (((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getDisableInteractiveSwitchLocal()) {
            return;
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        Intrinsics.checkNotNullExpressionValue(uidFromUin, "api(IRelationNTUinAndUid\u2026.java).getUidFromUin(uin)");
        LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(uidFromUin, 1, grayId, 1, true, false, null, 96, null);
        if (this.highLightInfoList.size() <= 0) {
            localGrayTipBuilder.g(wording, 1);
        } else {
            a(localGrayTipBuilder, wording);
        }
        QRouteApi api = QRoute.api(INtGrayTipApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
        INtGrayTipApi.a.a((INtGrayTipApi) api, app, localGrayTipBuilder.m(), null, 4, null);
    }

    @NotNull
    public final g d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.highLightInfoList.isEmpty()) {
            return this;
        }
        ArrayList<d.b> arrayList = this.highLightInfoList;
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new b());
        }
        return this;
    }

    @NotNull
    public final g e(@NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        this.commonUrl = url;
        return this;
    }

    @NotNull
    public final g f(@NotNull ArrayList<d.b> info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (g) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
        }
        Intrinsics.checkNotNullParameter(info, "info");
        this.highLightInfoList = info;
        return this;
    }
}
