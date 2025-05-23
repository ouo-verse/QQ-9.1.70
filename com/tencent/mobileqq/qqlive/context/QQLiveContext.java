package com.tencent.mobileqq.qqlive.context;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b,\u0010-B\u0011\b\u0016\u0012\u0006\u0010.\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000eR7\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0019j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u000eR\u001b\u0010$\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001c\u001a\u0004\b#\u0010\u000eR\u001b\u0010)\u001a\u00020%8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\f\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "appId", "<set-?>", "e", DomainData.DOMAIN_NAME, "traceId", "f", "k", QZoneDTLoginReporter.SCHEMA, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", h.F, "Lkotlin/Lazy;", "l", "()Ljava/util/HashMap;", "schemaAttrs", "i", "j", "from", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "source", "Lcom/tencent/mobileqq/qqlive/config/a;", BdhLogUtil.LogTag.Tag_Conn, "getConfig", "()Lcom/tencent/mobileqq/qqlive/config/a;", DownloadInfo.spKey_Config, "D", "_source", "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "E", "b", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveContext implements Parcelable {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<QQLiveContext> CREATOR;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Map<String, QQLiveContext> F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String _source;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String traceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String schema;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy schemaAttrs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy from;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/context/QQLiveContext$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements Parcelable.Creator<QQLiveContext> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQLiveContext createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQLiveContext) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQLiveContext(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQLiveContext[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQLiveContext[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new QQLiveContext[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/context/QQLiveContext$b;", "", "", "traceId", "e", "appId", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "c", "Landroid/content/Intent;", "intent", "a", "Lcom/tencent/mobileqq/qqlive/context/a;", "params", "b", "context", "", "f", "d", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "KEY_INTENT_APP_ID", "Ljava/lang/String;", "KEY_INTENT_SOURCE", "KEY_INTENT_TRACEID", "KEY_QQLIVE_CONTEXT", "TAG", "", "currentContexts", "Ljava/util/Map;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.context.QQLiveContext$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        private final String e(String traceId) {
            return "qqlive_context_" + traceId;
        }

        @NotNull
        public final QQLiveContext a(@Nullable Intent intent) {
            String str;
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQLiveContext) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            }
            if (intent != null) {
                str = intent.getStringExtra(QQLiveReportConstants.INTENT_TRACE_ID);
            } else {
                str = null;
            }
            if (intent != null) {
                str2 = intent.getStringExtra("key_intent_app_id");
            } else {
                str2 = null;
            }
            if (intent != null && intent.hasExtra("source")) {
                int intExtra = intent.getIntExtra("source", -1);
                if (intExtra < 0) {
                    str3 = intent.getStringExtra("source");
                } else {
                    str3 = String.valueOf(intExtra);
                }
            } else {
                str3 = null;
            }
            return b(new com.tencent.mobileqq.qqlive.context.a(str2, str, null, str3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        
            if (r6 != false) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final QQLiveContext b(@NotNull com.tencent.mobileqq.qqlive.context.a params) {
            boolean z16;
            QQLiveContext qQLiveContext;
            String a16;
            boolean isBlank;
            boolean isBlank2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (QQLiveContext) iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            }
            Intrinsics.checkNotNullParameter(params, "params");
            String d16 = params.d();
            boolean z17 = false;
            if (d16 != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(d16);
                if (!isBlank2) {
                    z16 = false;
                    if (z16) {
                        QLog.i("QQLiveContext", 1, "[build] no traceId specified");
                        d16 = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
                        Intrinsics.checkNotNull(d16);
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
                    qQLiveContext = (QQLiveContext) from.decodeParcelable(e(d16), QQLiveContext.class, null);
                    if (qQLiveContext == null) {
                        qQLiveContext = new QQLiveContext();
                        String a17 = params.a();
                        if (a17 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(a17);
                        }
                        z17 = true;
                        if (z17) {
                            a16 = QQLiveBusinessConfig.QQLIVE_APP_ID;
                        } else {
                            a16 = params.a();
                        }
                        qQLiveContext.o(a16);
                        qQLiveContext.traceId = d16;
                        String b16 = params.b();
                        String str = "";
                        if (b16 == null) {
                            b16 = "";
                        }
                        qQLiveContext.schema = b16;
                        String c16 = params.c();
                        if (c16 != null) {
                            str = c16;
                        }
                        qQLiveContext._source = str;
                        from.encodeParcelable(e(d16), qQLiveContext);
                        QQLiveContextCleaner.f271199e.d(d16);
                    }
                    QLog.d("QQLiveContext", 2, "[build] context: " + qQLiveContext + ", params=" + params);
                    return qQLiveContext;
                }
            }
            z16 = true;
            if (z16) {
            }
            MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
            Intrinsics.checkNotNullExpressionValue(from2, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
            qQLiveContext = (QQLiveContext) from2.decodeParcelable(e(d16), QQLiveContext.class, null);
            if (qQLiveContext == null) {
            }
            QLog.d("QQLiveContext", 2, "[build] context: " + qQLiveContext + ", params=" + params);
            return qQLiveContext;
        }

        @Nullable
        public final QQLiveContext c(@NotNull String appId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQLiveContext) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appId);
            }
            Intrinsics.checkNotNullParameter(appId, "appId");
            return (QQLiveContext) QQLiveContext.F.get(appId);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final QQLiveContext d(@Nullable String traceId) {
            boolean z16;
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (QQLiveContext) iPatchRedirector.redirect((short) 6, (Object) this, (Object) traceId);
            }
            if (traceId != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(traceId);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        QLog.w("QQLiveContext", 1, "[getContext] invalid traceId");
                        return null;
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
                    QQLiveContext qQLiveContext = (QQLiveContext) from.decodeParcelable(e(traceId), QQLiveContext.class, null);
                    if (qQLiveContext == null) {
                        QLog.w("QQLiveContext", 1, "[getContext] " + traceId + " has no context associated, ", new RuntimeException());
                    }
                    return qQLiveContext;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        public final void f(@Nullable QQLiveContext context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
                return;
            }
            QLog.i("QQLiveContext", 1, "[setCurrentContext] context=" + context);
            if (context != null) {
                QQLiveContext.F.put(context.g(), context);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30616);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
            return;
        }
        INSTANCE = new Companion(null);
        F = new LinkedHashMap();
        QQLiveContextCleaner.f271199e.e();
        CREATOR = new a();
    }

    public QQLiveContext() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.appId = "";
        this.traceId = "";
        this.schema = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.qqlive.context.QQLiveContext$schemaAttrs$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveContext.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (HashMap) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Uri parse = Uri.parse(QQLiveContext.this.k());
                HashMap<String, String> hashMap = new HashMap<>();
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "uri.queryParameterNames");
                for (String it : queryParameterNames) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    String queryParameter = parse.getQueryParameter(it);
                    if (queryParameter == null) {
                        queryParameter = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "uri.getQueryParameter(it) ?: \"\"");
                    hashMap.put(it, queryParameter);
                }
                return hashMap;
            }
        });
        this.schemaAttrs = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.context.QQLiveContext$from$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveContext.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                String str = QQLiveContext.this.l().get("from");
                return str == null ? "" : str;
            }
        });
        this.from = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.qqlive.context.QQLiveContext$source$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveContext.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str;
                boolean isBlank;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                str = QQLiveContext.this._source;
                QQLiveContext qQLiveContext = QQLiveContext.this;
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (isBlank) {
                    str = qQLiveContext.l().get("source");
                    if (str == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "schemaAttrs[\"source\"] ?: \"\"");
                }
                return str;
            }
        });
        this.source = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.config.a>() { // from class: com.tencent.mobileqq.qqlive.context.QQLiveContext$config$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveContext.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.qqlive.config.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? com.tencent.mobileqq.qqlive.config.a.INSTANCE.a(QQLiveContext.this.g()) : (com.tencent.mobileqq.qqlive.config.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.config = lazy4;
        this._source = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appId;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (String) this.from.getValue();
    }

    @NotNull
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.schema;
    }

    @NotNull
    public final HashMap<String, String> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (HashMap) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return (HashMap) this.schemaAttrs.getValue();
    }

    @NotNull
    public final String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (String) this.source.getValue();
    }

    @NotNull
    public final String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.traceId;
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appId = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "appId=" + this.appId + ", traceId=" + this.traceId + ", schema=" + this.schema;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) dest, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.appId);
        dest.writeString(this.traceId);
        dest.writeString(this.schema);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQLiveContext(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel);
            return;
        }
        String readString = parcel.readString();
        this.appId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.traceId = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.schema = readString3 != null ? readString3 : "";
    }
}
