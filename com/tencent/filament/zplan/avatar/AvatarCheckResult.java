package com.tencent.filament.zplan.avatar;

import com.tencent.filament.zplanservice.verify.ResourceCheckCode;
import com.tencent.filament.zplanservice.verify.ResourceCheckResult;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001\bBc\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00170\r\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u0006\u0010\"\u001a\u00020\u001d\u00a2\u0006\u0004\b#\u0010$J\u0011\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0086\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010R#\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00170\r8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\r8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\b\u0010\u0010R\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "", "other", "c", "", "", "d", "", "a", "Z", "b", "()Z", "passVerify", "", "Ljava/util/List;", "getAbnormalCodeUrls", "()Ljava/util/List;", "abnormalCodeUrls", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckCode;", "getAbnormalCodes", "abnormalCodes", "getFailUrls", "failUrls", "", "e", "getFailFileList", "failFileList", "f", "failDirs", "", "g", "J", "getTimeConsuming", "()J", "timeConsuming", "<init>", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;J)V", h.F, "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class AvatarCheckResult {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean passVerify;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> abnormalCodeUrls;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ResourceCheckCode> abnormalCodes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> failUrls;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String[]> failFileList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> failDirs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long timeConsuming;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplan/avatar/AvatarCheckResult$a;", "", "", "url", QzoneZipCacheHelper.DIR, "Lcom/tencent/filament/zplanservice/verify/ResourceCheckResult;", "result", "", "timeConsuming", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "b", "a", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.avatar.AvatarCheckResult$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final AvatarCheckResult a() {
            List emptyList;
            List emptyList2;
            List emptyList3;
            List emptyList4;
            List emptyList5;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            emptyList5 = CollectionsKt__CollectionsKt.emptyList();
            return new AvatarCheckResult(true, emptyList, emptyList2, emptyList3, emptyList4, emptyList5, 0L);
        }

        @NotNull
        public final AvatarCheckResult b(@NotNull String url, @NotNull String dir, @NotNull ResourceCheckResult result, long timeConsuming) {
            List emptyList;
            List emptyList2;
            List emptyList3;
            List emptyList4;
            List emptyList5;
            List listOf;
            List listOf2;
            List emptyList6;
            List emptyList7;
            List emptyList8;
            List emptyList9;
            List emptyList10;
            List listOf3;
            List listOf4;
            List listOf5;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(dir, "dir");
            Intrinsics.checkNotNullParameter(result, "result");
            if (!result.passVerification()) {
                emptyList9 = CollectionsKt__CollectionsKt.emptyList();
                emptyList10 = CollectionsKt__CollectionsKt.emptyList();
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(url);
                listOf4 = CollectionsKt__CollectionsJVMKt.listOf(result.getFailList());
                listOf5 = CollectionsKt__CollectionsJVMKt.listOf(dir);
                return new AvatarCheckResult(false, emptyList9, emptyList10, listOf3, listOf4, listOf5, timeConsuming);
            }
            if (a.f105671a[result.getCode().ordinal()] != 1) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(url);
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(result.getCode());
                emptyList6 = CollectionsKt__CollectionsKt.emptyList();
                emptyList7 = CollectionsKt__CollectionsKt.emptyList();
                emptyList8 = CollectionsKt__CollectionsKt.emptyList();
                return new AvatarCheckResult(true, listOf, listOf2, emptyList6, emptyList7, emptyList8, timeConsuming);
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
            emptyList4 = CollectionsKt__CollectionsKt.emptyList();
            emptyList5 = CollectionsKt__CollectionsKt.emptyList();
            return new AvatarCheckResult(true, emptyList, emptyList2, emptyList3, emptyList4, emptyList5, timeConsuming);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvatarCheckResult(boolean z16, @NotNull List<String> abnormalCodeUrls, @NotNull List<? extends ResourceCheckCode> abnormalCodes, @NotNull List<String> failUrls, @NotNull List<String[]> failFileList, @NotNull List<String> failDirs, long j3) {
        Intrinsics.checkNotNullParameter(abnormalCodeUrls, "abnormalCodeUrls");
        Intrinsics.checkNotNullParameter(abnormalCodes, "abnormalCodes");
        Intrinsics.checkNotNullParameter(failUrls, "failUrls");
        Intrinsics.checkNotNullParameter(failFileList, "failFileList");
        Intrinsics.checkNotNullParameter(failDirs, "failDirs");
        this.passVerify = z16;
        this.abnormalCodeUrls = abnormalCodeUrls;
        this.abnormalCodes = abnormalCodes;
        this.failUrls = failUrls;
        this.failFileList = failFileList;
        this.failDirs = failDirs;
        this.timeConsuming = j3;
    }

    @NotNull
    public final List<String> a() {
        return this.failDirs;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getPassVerify() {
        return this.passVerify;
    }

    @NotNull
    public final AvatarCheckResult c(@NotNull AvatarCheckResult other) {
        boolean z16;
        List plus;
        List plus2;
        List plus3;
        List plus4;
        List plus5;
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.passVerify && other.passVerify) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        plus = CollectionsKt___CollectionsKt.plus((Collection) this.abnormalCodeUrls, (Iterable) other.abnormalCodeUrls);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection) this.abnormalCodes, (Iterable) other.abnormalCodes);
        plus3 = CollectionsKt___CollectionsKt.plus((Collection) this.failUrls, (Iterable) other.failUrls);
        plus4 = CollectionsKt___CollectionsKt.plus((Collection) this.failFileList, (Iterable) other.failFileList);
        plus5 = CollectionsKt___CollectionsKt.plus((Collection) this.failDirs, (Iterable) other.failDirs);
        return new AvatarCheckResult(z17, plus, plus2, plus3, plus4, plus5, this.timeConsuming + other.timeConsuming);
    }

    @NotNull
    public final Map<String, String> d() {
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        String joinToString$default4;
        String joinToString$default5;
        Map<String, String> mapOf;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.failFileList, ";", null, null, 0, null, new Function1<String[], CharSequence>() { // from class: com.tencent.filament.zplan.avatar.AvatarCheckResult$toReportParam$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull String[] it) {
                String joinToString$default6;
                Intrinsics.checkNotNullParameter(it, "it");
                joinToString$default6 = ArraysKt___ArraysKt.joinToString$default(it, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                return joinToString$default6;
            }
        }, 30, null);
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(this.failUrls, ";", null, null, 0, null, null, 62, null);
        joinToString$default3 = CollectionsKt___CollectionsKt.joinToString$default(this.failDirs, ";", null, null, 0, null, null, 62, null);
        joinToString$default4 = CollectionsKt___CollectionsKt.joinToString$default(this.abnormalCodeUrls, ";", null, null, 0, null, null, 62, null);
        joinToString$default5 = CollectionsKt___CollectionsKt.joinToString$default(this.abnormalCodes, ";", null, null, 0, null, new Function1<ResourceCheckCode, CharSequence>() { // from class: com.tencent.filament.zplan.avatar.AvatarCheckResult$toReportParam$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull ResourceCheckCode it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return String.valueOf(it.getValue());
            }
        }, 30, null);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("fail_list", joinToString$default), TuplesKt.to("fail_urls", joinToString$default2), TuplesKt.to("fail_dirs", joinToString$default3), TuplesKt.to("pass_verify", String.valueOf(wx4.d.INSTANCE.b(this.passVerify))), TuplesKt.to("abnormal_code_urls", joinToString$default4), TuplesKt.to("abnormal_codes", joinToString$default5), TuplesKt.to(VRReportDefine$ReportParam.TIME_CONSUMING, String.valueOf(this.timeConsuming)));
        return mapOf;
    }
}
