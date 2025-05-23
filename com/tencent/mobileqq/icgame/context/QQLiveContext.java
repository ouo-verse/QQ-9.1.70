package com.tencent.mobileqq.icgame.context;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.icgame.common.api.IQQLiveReportApi;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\"\u0010\u0011\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\f\u001a\u0004\b\u0013\u0010\u000eR$\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR7\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0018j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u0015\u0010\u000eR\u001b\u0010\"\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001b\u001a\u0004\b!\u0010\u000eR\u001b\u0010'\u001a\u00020#8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/icgame/context/QQLiveContext;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "appId", "<set-?>", "l", "traceId", "f", "g", QZoneDTLoginReporter.SCHEMA, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", h.F, "Lkotlin/Lazy;", "j", "()Ljava/util/HashMap;", "schemaAttrs", "i", "from", "k", "source", "Ld32/a;", BdhLogUtil.LogTag.Tag_Conn, "getConfig", "()Ld32/a;", DownloadInfo.spKey_Config, "<init>", "()V", "parcel", "(Landroid/os/Parcel;)V", "D", "b", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QQLiveContext implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<QQLiveContext> CREATOR;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, QQLiveContext> E = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/icgame/context/QQLiveContext$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/icgame/context/QQLiveContext;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/icgame/context/QQLiveContext;", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements Parcelable.Creator<QQLiveContext> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQLiveContext createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQLiveContext(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQLiveContext[] newArray(int size) {
            return new QQLiveContext[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R \u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/icgame/context/QQLiveContext$b;", "", "", "traceId", "c", "appId", "Lcom/tencent/mobileqq/icgame/context/QQLiveContext;", "b", "Lcom/tencent/mobileqq/icgame/context/a;", "params", "a", "context", "", "d", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "KEY_INTENT_APP_ID", "Ljava/lang/String;", "KEY_INTENT_TRACEID", "KEY_QQLIVE_CONTEXT", "TAG", "", "currentContexts", "Ljava/util/Map;", "<init>", "()V", "ic-game-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.icgame.context.QQLiveContext$b, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String c(String traceId) {
            return "qqlive_context_" + traceId;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005f, code lost:
        
            if (r6 != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final QQLiveContext a(@NotNull BuildParams params) {
            boolean z16;
            QQLiveContext qQLiveContext;
            String appId;
            boolean isBlank;
            boolean isBlank2;
            Intrinsics.checkNotNullParameter(params, "params");
            String traceId = params.getTraceId();
            boolean z17 = false;
            if (traceId != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(traceId);
                if (!isBlank2) {
                    z16 = false;
                    if (z16) {
                        QLog.i("ICGameContext", 1, "[build] no traceId specified");
                        traceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
                        Intrinsics.checkNotNull(traceId);
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
                    qQLiveContext = (QQLiveContext) from.decodeParcelable(c(traceId), QQLiveContext.class, null);
                    if (qQLiveContext == null) {
                        qQLiveContext = new QQLiveContext();
                        String appId2 = params.getAppId();
                        if (appId2 != null) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(appId2);
                        }
                        z17 = true;
                        if (z17) {
                            appId = "1078";
                        } else {
                            appId = params.getAppId();
                        }
                        qQLiveContext.m(appId);
                        qQLiveContext.traceId = traceId;
                        String schema = params.getSchema();
                        if (schema == null) {
                            schema = "";
                        }
                        qQLiveContext.schema = schema;
                        from.encodeParcelable(c(traceId), qQLiveContext);
                        QQLiveContextCleaner.f237249e.d(traceId);
                    }
                    QLog.d("ICGameContext", 2, "[build] context: " + qQLiveContext + ", params=" + params);
                    return qQLiveContext;
                }
            }
            z16 = true;
            if (z16) {
            }
            MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
            Intrinsics.checkNotNullExpressionValue(from2, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
            qQLiveContext = (QQLiveContext) from2.decodeParcelable(c(traceId), QQLiveContext.class, null);
            if (qQLiveContext == null) {
            }
            QLog.d("ICGameContext", 2, "[build] context: " + qQLiveContext + ", params=" + params);
            return qQLiveContext;
        }

        @Nullable
        public final QQLiveContext b(@NotNull String appId) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return (QQLiveContext) QQLiveContext.E.get(appId);
        }

        public final void d(@Nullable QQLiveContext context) {
            QLog.i("ICGameContext", 1, "[setCurrentContext] context=" + context);
            if (context != null) {
                QQLiveContext.E.put(context.getAppId(), context);
            }
        }

        Companion() {
        }
    }

    static {
        QQLiveContextCleaner.f237249e.e();
        CREATOR = new a();
    }

    public QQLiveContext() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        this.appId = "";
        this.traceId = "";
        this.schema = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, String>>() { // from class: com.tencent.mobileqq.icgame.context.QQLiveContext$schemaAttrs$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, String> invoke() {
                Uri parse = Uri.parse(QQLiveContext.this.getSchema());
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
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.icgame.context.QQLiveContext$from$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str = QQLiveContext.this.j().get("from");
                return str == null ? "" : str;
            }
        });
        this.from = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.icgame.context.QQLiveContext$source$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str = QQLiveContext.this.j().get("source");
                return str == null ? "" : str;
            }
        });
        this.source = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<d32.a>() { // from class: com.tencent.mobileqq.icgame.context.QQLiveContext$config$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d32.a invoke() {
                return d32.a.INSTANCE.a(QQLiveContext.this.getAppId());
            }
        });
        this.config = lazy4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    public final String f() {
        return (String) this.from.getValue();
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    @NotNull
    public final HashMap<String, String> j() {
        return (HashMap) this.schemaAttrs.getValue();
    }

    @NotNull
    public final String k() {
        return (String) this.source.getValue();
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appId = str;
    }

    @NotNull
    public String toString() {
        return "appId=" + this.appId + ", traceId=" + this.traceId + ", schema=" + this.schema;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.appId);
        dest.writeString(this.traceId);
        dest.writeString(this.schema);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QQLiveContext(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.appId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.traceId = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.schema = readString3 != null ? readString3 : "";
    }
}
