package com.tencent.mobileqq.unusedcodecheck;

import android.os.SystemClock;
import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.imsdk.BaseConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 H2\u00020\u0001:\u0001\u0011B\u0019\u0012\u0006\u0010B\u001a\u00020?\u0012\b\b\u0002\u0010E\u001a\u00020\u001b\u00a2\u0006\u0004\bF\u0010GJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004H\u0086 J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0004J\b\u0010\"\u001a\u0004\u0018\u00010\tJ\u0016\u0010#\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010%\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010&R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\t0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b)\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010$R\u0018\u00105\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010$R\u0016\u00107\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010&R\u0016\u00109\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010&R\u0018\u0010<\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010&R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/CheckCore;", "", "Ljava/util/BitSet;", "resultBitSet", "", "allClassCount", "partClassCount", "", "d", "", "firstClass", "lastClass", "b", "Ljava/io/File;", "loadedClassInfoFile", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "checkResultObject", "a", "e", "Ljava/lang/ClassLoader;", "classLoader", "checkCore", "partSize", "checkClassLoadedResult", "storeCheckInfo$unusedcode_check_debug", "(I)V", "storeCheckInfo", "", "isCheckSuc$unusedcode_check_debug", "()Z", "isCheckSuc", "isCheckInitState", "usedIndex", "updateMarker", "nextElement", "onPartFinish", "Ljava/lang/String;", "processName", "I", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "c", "Lkotlin/Lazy;", "()Ljava/util/List;", "partNames", "", "Ljava/util/List;", "hashBucket", "Ljava/util/BitSet;", "currentMarker", "f", "currentPartFirstClass", "g", "currentPartLastClass", tl.h.F, "currentClassIndex", "i", "currentPartIndex", "j", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "currentCacheLoadedInfo", "k", "checkClassCount", "Lcom/tencent/mobileqq/unusedcodecheck/f;", "l", "Lcom/tencent/mobileqq/unusedcodecheck/f;", "classDefs", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "checkInitStatus", "<init>", "(Lcom/tencent/mobileqq/unusedcodecheck/f;Z)V", "o", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class CheckCore {
    static IPatchRedirector $redirector_;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Lazy f306055n;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String processName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int statusCode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy partNames;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<String> hashBucket;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BitSet currentMarker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String currentPartFirstClass;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String currentPartLastClass;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int currentClassIndex;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentPartIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private LoadedClassInfoObject currentCacheLoadedInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int checkClassCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final f classDefs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean checkInitStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0013\u001a\u00020\b8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00148\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0014\u0010 \u001a\u00020\u00028\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/CheckCore$a;", "", "", "processName", "partName", "version", "", "mkDirs", "Ljava/io/File;", "b", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/io/File;", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;", "d", "(Ljava/lang/String;)Ljava/io/File;", "currentVersionDirFile$delegate", "Lkotlin/Lazy;", "a", "()Ljava/io/File;", "currentVersionDirFile", "", "CHECK_ERROR_CODE_LOAD_DEF_FILE_FAILED", "I", "CHECK_ERROR_CODE_RESULT_FILE_DESERIALIZABLE_FAILED", "CHECK_ERROR_CODE_RESULT_FILE_SERIALIZABLE_FAILED", "CHECK_ERROR_CODE_SUC", "CHECK_ERROR_CODE_VERIFY_FILE_FAILED", "CHECK_ERROR_CODE_VERIFY_STORE_FILE_FAILED", "CHECK_HASH_COUNT_GAP", "CHECK_TAG", "Ljava/lang/String;", "CLASS_LOADED_MARK", "COMBINE_INFO_NAME", "LOAD_CLASS_INFO_FILE_NAME", "TAG", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.CheckCore$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @NotNull
        public final File a() {
            Object value;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                value = iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                value = CheckCore.f306055n.getValue();
            }
            return (File) value;
        }

        @NotNull
        public final File b(@NotNull String processName, @NotNull String partName, @NotNull String version, boolean mkDirs) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (File) iPatchRedirector.redirect((short) 2, this, processName, partName, version, Boolean.valueOf(mkDirs));
            }
            Intrinsics.checkNotNullParameter(processName, "processName");
            Intrinsics.checkNotNullParameter(partName, "partName");
            Intrinsics.checkNotNullParameter(version, "version");
            File file = new File(c(processName, version), partName);
            if (mkDirs) {
                file.mkdirs();
            }
            return new File(file, "info");
        }

        @NotNull
        public final File c(@NotNull String processName, @NotNull String version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (File) iPatchRedirector.redirect((short) 3, (Object) this, (Object) processName, (Object) version);
            }
            Intrinsics.checkNotNullParameter(processName, "processName");
            Intrinsics.checkNotNullParameter(version, "version");
            return new File(d(version), processName);
        }

        @NotNull
        public final File d(@NotNull String version) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) version);
            }
            Intrinsics.checkNotNullParameter(version, "version");
            return new File(InitClassInfo.INSTANCE.c(), version);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(BaseConstants.ERR_SDK_ACCOUNT_LOGIN_IN_PROCESS);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(CheckCore$Companion$currentVersionDirFile$2.INSTANCE);
        f306055n = lazy;
    }

    public CheckCore(@NotNull f classDefs, boolean z16) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(classDefs, "classDefs");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, classDefs, Boolean.valueOf(z16));
            return;
        }
        this.classDefs = classDefs;
        this.checkInitStatus = z16;
        String b16 = b.f306127n.n().b();
        Intrinsics.checkNotNull(b16);
        this.processName = b16;
        lazy = LazyKt__LazyJVMKt.lazy(CheckCore$partNames$2.INSTANCE);
        this.partNames = lazy;
        this.hashBucket = new ArrayList();
        this.currentMarker = new BitSet();
    }

    private final LoadedClassInfoObject a(File loadedClassInfoFile, LoadedClassInfoObject checkResultObject) {
        if (!loadedClassInfoFile.exists()) {
            return checkResultObject;
        }
        LoadedClassInfoObject b16 = a.INSTANCE.b(loadedClassInfoFile);
        if (b16 == null) {
            this.statusCode = MessageRecord.MSG_TYPE_FAILED_MSG;
            return null;
        }
        LoadedClassInfoObject loadedClassInfoObject = this.currentCacheLoadedInfo;
        if (loadedClassInfoObject != null && !checkResultObject.checkConsistency(loadedClassInfoObject)) {
            this.statusCode = MessageRecord.MSG_TYPE_MULTI_VIDEO;
            LoadedClassInfoObject loadedClassInfoObject2 = this.currentCacheLoadedInfo;
            Intrinsics.checkNotNull(loadedClassInfoObject2);
            File file = loadedClassInfoObject2.srcFile;
            if (file != null) {
                file.delete();
            }
            b.f306127n.n().e("UnusedCodeCheck.Check", "onPartFinish verify store file error loadedClassInfoFile:" + loadedClassInfoFile + " currentCacheLoadedInfo.srcFile:" + file);
            return null;
        }
        if (!b16.checkConsistency(checkResultObject)) {
            this.statusCode = MessageRecord.MSG_TYPE_SHIELD_MSG;
            loadedClassInfoFile.delete();
            b.f306127n.n().e("UnusedCodeCheck.Check", "onPartFinish verify file error loadedClassInfoFile:" + loadedClassInfoFile);
            return null;
        }
        b16.getMarker().or(checkResultObject.getMarker());
        b16.setCheckCount(b16.getCheckCount() + 1);
        loadedClassInfoFile.delete();
        return b16;
    }

    private final String b(String firstClass, String lastClass) {
        String valueOf = String.valueOf(SystemClock.uptimeMillis());
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                Charset charset = Charsets.UTF_8;
                if (firstClass != null) {
                    byte[] bytes = firstClass.getBytes(charset);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    messageDigest.update(bytes);
                    for (String str : this.hashBucket) {
                        if (str != null) {
                            byte[] bytes2 = str.getBytes(charset);
                            Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                            messageDigest.update(bytes2);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                    if (lastClass != null) {
                        byte[] bytes3 = lastClass.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "(this as java.lang.String).getBytes(charset)");
                        messageDigest.update(bytes3);
                        String encodeToString = Base64.encodeToString(messageDigest.digest(), 11);
                        Intrinsics.checkNotNullExpressionValue(encodeToString, "Base64.encodeToString(\n \u2026e64.NO_WRAP\n            )");
                        this.hashBucket.clear();
                        return encodeToString;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } catch (Exception e16) {
                b.f306127n.n().h("UnusedCodeCheck.Check", "generateCheckHashResult error", e16);
                this.hashBucket.clear();
                return valueOf;
            }
        } catch (Throwable unused) {
            this.hashBucket.clear();
            return valueOf;
        }
    }

    private final List<String> c() {
        return (List) this.partNames.getValue();
    }

    private final void d(BitSet resultBitSet, int allClassCount, int partClassCount) {
        String str = this.currentPartFirstClass;
        Intrinsics.checkNotNull(str);
        String str2 = this.currentPartLastClass;
        Intrinsics.checkNotNull(str2);
        String b16 = b(str, str2);
        String str3 = this.currentPartFirstClass;
        Intrinsics.checkNotNull(str3);
        String str4 = this.currentPartLastClass;
        Intrinsics.checkNotNull(str4);
        LoadedClassInfoObject loadedClassInfoObject = new LoadedClassInfoObject(resultBitSet, allClassCount, partClassCount, str3, str4, 1, b16);
        Companion companion = INSTANCE;
        String str5 = this.processName;
        String valueOf = String.valueOf(allClassCount);
        b bVar = b.f306127n;
        File b17 = companion.b(str5, valueOf, bVar.f(), true);
        LoadedClassInfoObject a16 = a(b17, loadedClassInfoObject);
        if (a16 == null) {
            return;
        }
        boolean c16 = a.INSTANCE.c(b17, a16);
        if (!c16) {
            this.statusCode = MessageRecord.MSG_TYPE_GROUPDISC_FILE;
        }
        bVar.n().c("UnusedCodeCheck.Check", "onPartFinish process:" + this.processName + " info:" + a16.getInfo() + "} saveResult:" + c16 + " checkClassCount:" + this.checkClassCount);
    }

    private final void e() {
        if (c().isEmpty() || this.currentPartIndex >= c().size()) {
            return;
        }
        File b16 = INSTANCE.b("combine", c().get(this.currentPartIndex), b.f306127n.f(), false);
        if (b16.exists()) {
            LoadedClassInfoObject b17 = a.INSTANCE.b(b16);
            this.currentCacheLoadedInfo = b17;
            if (b17 != null) {
                b17.srcFile = b16;
            }
        }
    }

    public final native int checkClassLoadedResult(@NotNull ClassLoader classLoader, @NotNull CheckCore checkCore, int partSize);

    public final boolean isCheckInitState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.checkInitStatus;
    }

    public final boolean isCheckSuc$unusedcode_check_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.statusCode == 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String nextElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        try {
            String nextElement = this.classDefs.nextElement();
            if (nextElement != null) {
                if (this.currentPartFirstClass == null) {
                    this.currentPartFirstClass = nextElement;
                }
                this.currentPartLastClass = nextElement;
                int i3 = this.currentClassIndex + 1;
                this.currentClassIndex = i3;
                if (i3 % 8192 == 0) {
                    this.hashBucket.add(nextElement);
                }
                LoadedClassInfoObject loadedClassInfoObject = this.currentCacheLoadedInfo;
                if (loadedClassInfoObject != null && loadedClassInfoObject.addIndexAndCheckClassIsLoaded()) {
                    return "loaded_mark";
                }
                this.checkClassCount++;
            }
            return nextElement;
        } catch (IOException unused) {
            this.statusCode = MessageRecord.MSG_TYPE_STRUCT_MSG;
            return null;
        }
    }

    public final void onPartFinish(int allClassCount, int partClassCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(allClassCount), Integer.valueOf(partClassCount));
            return;
        }
        d(this.currentMarker, allClassCount, partClassCount);
        this.currentMarker = new BitSet();
        this.currentPartFirstClass = null;
        this.currentPartIndex++;
        e();
    }

    public final void storeCheckInfo$unusedcode_check_debug(int partSize) {
        CheckStateData checkStateData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, partSize);
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        b bVar = b.f306127n;
        bVar.n().c("UnusedCodeCheck.Check", "storeInfo start");
        if (Intrinsics.areEqual(bVar.l(), this.processName)) {
            checkStateData = CheckStateData.INSTANCE.b();
            checkStateData.l(checkStateData.e() + 1);
            bVar.n().d("unusedcodecheck_mmkv_check_state_data", checkStateData);
        } else {
            checkStateData = null;
        }
        e();
        ClassLoader classLoader = CheckCore.class.getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        Intrinsics.checkNotNullExpressionValue(classLoader, "this.javaClass.classLoader!!");
        int checkClassLoadedResult = checkClassLoadedResult(classLoader, this, partSize);
        if (checkClassLoadedResult == 0) {
            if (checkStateData != null) {
                checkStateData.l(0);
                checkStateData.k(checkStateData.c() + 1);
                bVar.n().d("unusedcodecheck_mmkv_check_state_data", checkStateData);
            }
        } else {
            this.statusCode = checkClassLoadedResult;
        }
        this.classDefs.release();
        bVar.n().e("UnusedCodeCheck.Check", "storeInfo end statusCode:" + this.statusCode + " cost:" + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    public final void updateMarker(int usedIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, usedIndex);
        } else {
            this.currentMarker.set(usedIndex);
        }
    }

    public /* synthetic */ CheckCore(f fVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, (i3 & 2) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, fVar, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
