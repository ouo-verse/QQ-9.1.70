package com.tencent.mobileqq.wink.context;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.openingending.WinkEditorOpeningEndingOutputRouter;
import com.tencent.mobileqq.wink.picker.WinkMediaInfos;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\u0001SB\u0007\u00a2\u0006\u0004\bO\u0010PB\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\bO\u0010QJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R$\u0010,\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\"\u00101\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(\"\u0004\b/\u00100R$\u00107\u001a\u0002022\u0006\u0010$\u001a\u0002028\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R$\u0010;\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b5\u00108\u001a\u0004\b9\u0010:R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010&\u001a\u0004\b=\u0010(\"\u0004\b>\u00100R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR6\u0010J\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/wink/context/WinkContext;", "Landroid/os/Parcelable;", "Landroid/content/Intent;", "intent", "", "t", "", "key", "p", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "r", "missionID", "y", "path", "", "w", "name", "u", "isEdit", DomainData.DOMAIN_NAME, "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "toString", "Lcom/tencent/mobileqq/wink/context/q;", "d", "Lcom/tencent/mobileqq/wink/context/q;", "k", "()Lcom/tencent/mobileqq/wink/context/q;", HippyTKDListViewAdapter.X, "(Lcom/tencent/mobileqq/wink/context/q;)V", "businessConfig", "<set-?>", "e", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "traceId", "f", "o", "missionId", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ljava/lang/String;)V", "schemaString", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", "i", "Lcom/tencent/mobileqq/wink/context/WinkExodus;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/wink/context/WinkExodus;", "exodus", "Z", "v", "()Z", "isFirstPage", BdhLogUtil.LogTag.Tag_Conn, "getRefPgid", "setRefPgid", "refPgid", "Lcom/tencent/mobileqq/wink/context/DaTongParams;", "D", "Lcom/tencent/mobileqq/wink/context/DaTongParams;", "l", "()Lcom/tencent/mobileqq/wink/context/DaTongParams;", "setDtParams", "(Lcom/tencent/mobileqq/wink/context/DaTongParams;)V", "dtParams", "E", "Ljava/util/HashMap;", "schemaAttrs", "Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/picker/WinkMediaInfos;", "mediaInfos", "<init>", "()V", "(Landroid/os/Parcel;)V", "G", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkContext implements Parcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WinkContext> CREATOR;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Uri> H;
    private static volatile WinkContext I;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private String refPgid;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    @NotNull
    private DaTongParams dtParams;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @Nullable
    private HashMap<String, String> schemaAttrs;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private WinkMediaInfos mediaInfos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public q businessConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String traceId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String missionId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String schemaString;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WinkExodus exodus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/context/WinkContext$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/context/WinkContext;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/context/WinkContext;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<WinkContext> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkContext createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkContext(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkContext[] newArray(int size) {
            return new WinkContext[size];
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006R\u001b\u0010\"\u001a\u00020\u001d8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/context/WinkContext$b;", "", "Lcom/tencent/mobileqq/wink/context/WinkContext;", "winkContext", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "traceId", DomainData.DOMAIN_NAME, "d", "e", "l", "isEdit", "i", tl.h.F, "", "o", "Landroid/os/Bundle;", "bundle", "b", "Landroid/content/Intent;", "intent", "a", "Lcom/tencent/mobileqq/wink/context/b;", "params", "c", "g", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "f", "Landroid/net/Uri;", "winkActivityReferrerUri$delegate", "Lkotlin/Lazy;", "k", "()Landroid/net/Uri;", "winkActivityReferrerUri", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "KEY_ATTRS", "Ljava/lang/String;", "KEY_INTENT_TRACE_ID", "KEY_SCHEMA", "KEY_SCHEMA_RETURN_SCHEMA", "KEY_SCHEMA_TASK_ID", "KEY_SCHEMA_USER_DATA", "KEY_WINK_CONTEXT", "TAG", "WINK_ACTIVITY_REFERRER_URI_STR", "currentContext", "Lcom/tencent/mobileqq/wink/context/WinkContext;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.context.WinkContext$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String j(Companion companion, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            return companion.i(z16);
        }

        private final boolean m(WinkContext winkContext) {
            if (l()) {
                WinkContext winkContext2 = WinkContext.I;
                WinkContext winkContext3 = null;
                if (winkContext2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentContext");
                    winkContext2 = null;
                }
                if (!Intrinsics.areEqual(winkContext2.getTraceId(), winkContext.getTraceId()) && !winkContext.w(WinkEditorOpeningEndingOutputRouter.ROUTE_PATH)) {
                    WinkContext winkContext4 = WinkContext.I;
                    if (winkContext4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentContext");
                    } else {
                        winkContext3 = winkContext4;
                    }
                    if (!winkContext3.w(WinkEditorOpeningEndingOutputRouter.ROUTE_PATH)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return true;
        }

        private final String n(String traceId) {
            return "key_wink_context_" + traceId;
        }

        @NotNull
        public final WinkContext a(@NotNull Intent intent) {
            HashMap hashMap;
            Intrinsics.checkNotNullParameter(intent, "intent");
            String stringExtra = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
            if (stringExtra == null) {
                stringExtra = "";
            }
            String str = stringExtra;
            String stringExtra2 = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            String stringExtra3 = intent.getStringExtra(QQWinkConstants.MISSION_ID);
            Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
            String str2 = null;
            if (serializableExtra instanceof HashMap) {
                hashMap = (HashMap) serializableExtra;
            } else {
                hashMap = null;
            }
            String stringExtra4 = intent.getStringExtra("key_scheme");
            String stringExtra5 = intent.getStringExtra("wink_output_route");
            if (stringExtra5 == null) {
                if (hashMap != null) {
                    str2 = (String) hashMap.get("wink_output_route");
                }
            } else {
                str2 = stringExtra5;
            }
            long j3 = 0;
            long longExtra = intent.getLongExtra("wink_output_point", 0L);
            if (longExtra == 0) {
                if (hashMap != null) {
                    try {
                        String str3 = (String) hashMap.get("wink_output_point");
                        if (str3 != null) {
                            j3 = Long.parseLong(str3);
                        }
                    } catch (Exception e16) {
                        w53.b.e("WinkContext", e16);
                    }
                }
                longExtra = j3;
            }
            BuildParams buildParams = new BuildParams(str, stringExtra2, stringExtra3, hashMap, stringExtra4, new WinkExodus(str2, longExtra));
            QLog.i("WinkContext", 1, "[build]bundle params=" + buildParams);
            return c(buildParams);
        }

        @NotNull
        public final WinkContext b(@NotNull Bundle bundle) {
            HashMap hashMap;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String businessName = bundle.getString(QQWinkConstants.ENTRY_BUSINESS_NAME, "");
            String string = bundle.getString(PeakConstants.QCIRCLE_CLIENT_TRACEID);
            String string2 = bundle.getString(QQWinkConstants.MISSION_ID);
            Serializable serializable = bundle.getSerializable("key_attrs");
            String str = null;
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            String string3 = bundle.getString("key_scheme");
            String string4 = bundle.getString("wink_output_route");
            if (string4 == null) {
                if (hashMap != null) {
                    str = (String) hashMap.get("wink_output_route");
                }
            } else {
                str = string4;
            }
            long j3 = bundle.getLong("wink_output_point");
            if (j3 == 0) {
                if (hashMap != null) {
                    try {
                        String str2 = (String) hashMap.get("wink_output_point");
                        if (str2 != null) {
                            j3 = Long.parseLong(str2);
                        }
                    } catch (Exception e16) {
                        w53.b.e("WinkContext", e16);
                    }
                }
                j3 = 0;
            }
            Intrinsics.checkNotNullExpressionValue(businessName, "businessName");
            BuildParams buildParams = new BuildParams(businessName, string, string2, hashMap, string3, new WinkExodus(str, j3));
            QLog.i("WinkContext", 1, "[build]bundle params=" + buildParams);
            return c(buildParams);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0069, code lost:
        
            if (r13 != false) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WinkContext c(@NotNull BuildParams params) {
            boolean z16;
            WinkContext winkContext;
            String c16;
            Map mapOf;
            String missionId;
            boolean isBlank;
            boolean isBlank2;
            boolean isBlank3;
            Intrinsics.checkNotNullParameter(params, "params");
            String traceId = params.getTraceId();
            boolean z17 = false;
            if (traceId != null) {
                isBlank3 = StringsKt__StringsJVMKt.isBlank(traceId);
                if (!isBlank3) {
                    z16 = false;
                    if (z16) {
                        QLog.w("WinkContext", 1, "[build] no trace id specified");
                        traceId = g();
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "QCIRCLE_MMKV_COMMON");
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026QWinkConstants.MMKV_FILE)");
                    winkContext = (WinkContext) from.decodeParcelable(n(traceId), WinkContext.class, null);
                    String str = "";
                    if (winkContext == null) {
                        q c17 = q.INSTANCE.c(params.getBusinessName());
                        WinkContext winkContext2 = new WinkContext();
                        winkContext2.traceId = traceId;
                        String missionId2 = params.getMissionId();
                        if (missionId2 != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(missionId2);
                        }
                        z17 = true;
                        if (z17) {
                            QLog.w("WinkContext", 1, "[build] no mission id specified");
                            missionId = WinkContext.INSTANCE.f(c17.a());
                        } else {
                            missionId = params.getMissionId();
                        }
                        winkContext2.missionId = missionId;
                        winkContext2.x(c17);
                        winkContext2.schemaAttrs = params.d();
                        String schemaString = params.getSchemaString();
                        if (schemaString == null) {
                            schemaString = "";
                        }
                        winkContext2.z(schemaString);
                        WinkExodus exodus = params.getExodus();
                        if (exodus == null) {
                            exodus = new WinkExodus(null, 0L, 2, null);
                        }
                        winkContext2.exodus = exodus;
                        DaTongParams dtParams = winkContext2.getDtParams();
                        String c18 = c17.c();
                        isBlank = StringsKt__StringsJVMKt.isBlank(c18);
                        if (isBlank) {
                            c18 = l.f318051b.c();
                        }
                        dtParams.e(c18);
                        dtParams.f(DaTongParams.INSTANCE.a());
                        QLog.i("WinkContext", 2, "[build] encode winkContext");
                        String n3 = n(traceId);
                        from.encodeParcelable(n3, winkContext2);
                        if (QLog.isColorLevel()) {
                            QLog.i("WinkContext", 2, "[build] decode winkContext immediately: " + ((WinkContext) from.decodeParcelable(n3, WinkContext.class, null)));
                        }
                        from.commitSync();
                        WinkContextCleaner.f318027e.d(traceId);
                        winkContext = winkContext2;
                    }
                    QLog.d("WinkContext", 2, "[build] winkContext: " + winkContext);
                    com.tencent.mobileqq.wink.report.e eVar = com.tencent.mobileqq.wink.report.e.f326265a;
                    c16 = com.tencent.mobileqq.statistics.o.c();
                    if (c16 != null) {
                        str = c16;
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("device_id", str));
                    com.tencent.mobileqq.wink.report.e.o(eVar, WinkDengtaReportConstant.Action.EXPOSE_CIRCLE_PUBLISHER_PAGE, mapOf, false, 4, null);
                    return winkContext;
                }
            }
            z16 = true;
            if (z16) {
            }
            MMKVOptionEntity from2 = QMMKV.from(MobileQQ.sMobileQQ, "QCIRCLE_MMKV_COMMON");
            Intrinsics.checkNotNullExpressionValue(from2, "from(MobileQQ.sMobileQQ,\u2026QWinkConstants.MMKV_FILE)");
            winkContext = (WinkContext) from2.decodeParcelable(n(traceId), WinkContext.class, null);
            String str2 = "";
            if (winkContext == null) {
            }
            QLog.d("WinkContext", 2, "[build] winkContext: " + winkContext);
            com.tencent.mobileqq.wink.report.e eVar2 = com.tencent.mobileqq.wink.report.e.f326265a;
            c16 = com.tencent.mobileqq.statistics.o.c();
            if (c16 != null) {
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("device_id", str2));
            com.tencent.mobileqq.wink.report.e.o(eVar2, WinkDengtaReportConstant.Action.EXPOSE_CIRCLE_PUBLISHER_PAGE, mapOf, false, 4, null);
            return winkContext;
        }

        @NotNull
        public final WinkContext d() {
            WinkContext winkContext = WinkContext.I;
            if (winkContext == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentContext");
                return null;
            }
            return winkContext;
        }

        @Nullable
        public final WinkContext e() {
            if (l()) {
                WinkContext winkContext = WinkContext.I;
                if (winkContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentContext");
                    return null;
                }
                return winkContext;
            }
            return null;
        }

        @NotNull
        public final String f(@NotNull String businessName) {
            Intrinsics.checkNotNullParameter(businessName, "businessName");
            return businessName + "_" + UUID.randomUUID();
        }

        @NotNull
        public final String g() {
            String format = new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
            String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + format + "_" + UUID.randomUUID();
            QLog.d("WinkContext", 1, "traceId: " + str);
            return str;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0013  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final WinkContext h(@Nullable String traceId) {
            boolean z16;
            boolean isBlank;
            if (traceId != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(traceId);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        QLog.e("WinkContext", 1, "[get] invalid traceId");
                        return null;
                    }
                    MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "QCIRCLE_MMKV_COMMON");
                    Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026QWinkConstants.MMKV_FILE)");
                    WinkContext winkContext = (WinkContext) from.decodeParcelable(n(traceId), WinkContext.class, null);
                    if (winkContext == null) {
                        QLog.w("WinkContext", 1, "[get] " + traceId + " has no context associated", new RuntimeException());
                    }
                    return winkContext;
                }
            }
            z16 = true;
            if (!z16) {
            }
        }

        @NotNull
        public final String i(boolean isEdit) {
            if (l()) {
                WinkContext winkContext = WinkContext.I;
                if (winkContext == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentContext");
                    winkContext = null;
                }
                return winkContext.n(isEdit);
            }
            if (isEdit) {
                return QQWinkConstants.ENTRY_QQ_OTHER_EDIT;
            }
            return QQWinkConstants.ENTRY_QQ_OTHER;
        }

        @NotNull
        public final Uri k() {
            Object value = WinkContext.H.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-winkActivityReferrerUri>(...)");
            return (Uri) value;
        }

        public final boolean l() {
            if (WinkContext.I != null) {
                return true;
            }
            return false;
        }

        public final void o(@NotNull WinkContext winkContext) {
            Intrinsics.checkNotNullParameter(winkContext, "winkContext");
            if (m(winkContext)) {
                com.tencent.mobileqq.wink.model.b.f324006a.a();
            }
            WinkContext.I = winkContext;
        }

        Companion() {
        }
    }

    static {
        Lazy<Uri> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Uri>() { // from class: com.tencent.mobileqq.wink.context.WinkContext$Companion$winkActivityReferrerUri$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Uri invoke() {
                return Uri.parse("wink://activity");
            }
        });
        H = lazy;
        WinkContextCleaner.f318027e.e();
        CREATOR = new a();
    }

    public WinkContext() {
        this.traceId = "";
        this.missionId = "";
        this.schemaString = "";
        this.isFirstPage = true;
        this.refPgid = "";
        this.dtParams = new DaTongParams();
        this.mediaInfos = new WinkMediaInfos(new ArrayList(), new ArrayList());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final q k() {
        q qVar = this.businessConfig;
        if (qVar != null) {
            return qVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("businessConfig");
        return null;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final DaTongParams getDtParams() {
        return this.dtParams;
    }

    @NotNull
    public final WinkExodus m() {
        WinkExodus winkExodus = this.exodus;
        if (winkExodus != null) {
            return winkExodus;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exodus");
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c0 A[ORIG_RETURN, RETURN] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String n(boolean isEdit) {
        String a16 = k().a();
        switch (a16.hashCode()) {
            case -1322459498:
                if (a16.equals("qqstranger")) {
                    if (isEdit) {
                        return QQWinkConstants.ENTRY_QQ_STRANGER_EDIT;
                    }
                    return "qq_stranger";
                }
                if (!isEdit) {
                    return QQWinkConstants.ENTRY_QQ_OTHER_EDIT;
                }
                return QQWinkConstants.ENTRY_QQ_OTHER;
            case -1274223135:
                if (a16.equals("filetbstool")) {
                    if (isEdit) {
                        return QQWinkConstants.ENTRY_QQ_TBS_TOOL_EDIT;
                    }
                    return QQWinkConstants.ENTRY_QQ_TBS_TOOL;
                }
                if (!isEdit) {
                }
                break;
            case -176742241:
                if (a16.equals("qqnearby")) {
                    if (isEdit) {
                        return QQWinkConstants.ENTRY_QQ_NEARBY_EDIT;
                    }
                    return QQWinkConstants.ENTRY_QQ_NEARBY;
                }
                if (!isEdit) {
                }
                break;
            case 77564797:
                if (a16.equals("QZONE")) {
                    if (!Intrinsics.areEqual(this.refPgid, QQWinkConstants.REF_FROM_QZONE_ALBUM_UPLOAD) && !Intrinsics.areEqual(this.refPgid, QQWinkConstants.REF_FROM_QZONE_ALBUM_RESHIP)) {
                        if (isEdit) {
                            return QQWinkConstants.ENTRY_QQ_QZONE_EDIT;
                        }
                        return QQWinkConstants.ENTRY_QQ_QZONE;
                    }
                    if (isEdit) {
                        return QQWinkConstants.ENTRY_QQ_GALLERY_EDIT;
                    }
                    return "qq_gallery";
                }
                if (!isEdit) {
                }
                break;
            case 861433953:
                if (a16.equals("QCIRCLE")) {
                    if (isEdit) {
                        return QQWinkConstants.ENTRY_QQ_WORLD_EDIT;
                    }
                    return QQWinkConstants.ENTRY_QQ_WORLD;
                }
                if (!isEdit) {
                }
                break;
            case 1172029062:
                if (a16.equals("emoticon")) {
                    return QQWinkConstants.ENTRY_QQ_EMOTION;
                }
                if (!isEdit) {
                }
                break;
            case 1506520400:
                if (a16.equals("AI_AVATAR")) {
                    return QQWinkConstants.ENTRY_QQ_AI_AVATAR;
                }
                if (!isEdit) {
                }
                break;
            default:
                if (!isEdit) {
                }
                break;
        }
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final String p(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        HashMap<String, String> hashMap = this.schemaAttrs;
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getSchemaString() {
        return this.schemaString;
    }

    @Nullable
    public final HashMap<String, String> r() {
        return this.schemaAttrs;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final void t(@Nullable Intent intent) {
        String str;
        this.isFirstPage = f.f318044a.a(intent);
        if (intent != null) {
            str = intent.getStringExtra("xsj_ref_pgid");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.refPgid = str;
        QLog.i("WinkContext", 1, "[identifyFirstPage] isFirstPage=" + this.isFirstPage + ", refPgid=" + str);
    }

    @NotNull
    public String toString() {
        return "traceId=" + this.traceId + ", missionId=" + this.missionId + ", businessConfig=" + k() + ", schemaString=" + this.schemaString + ", schemaAttrs=" + this.schemaAttrs + ", exodus=" + m() + ", dtParams=" + this.dtParams + ", refPgid=" + this.refPgid;
    }

    public final boolean u(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Intrinsics.areEqual(k().a(), name);
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsFirstPage() {
        return this.isFirstPage;
    }

    public final boolean w(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return m().g(path);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.traceId);
        parcel.writeString(this.missionId);
        q.INSTANCE.d(parcel, k());
        parcel.writeSerializable(this.schemaAttrs);
        parcel.writeString(this.schemaString);
        parcel.writeParcelable(m(), 0);
        parcel.writeParcelable(this.dtParams, 0);
        parcel.writeString(this.refPgid);
    }

    public final void x(@NotNull q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "<set-?>");
        this.businessConfig = qVar;
    }

    public final void y(@NotNull String missionID) {
        Intrinsics.checkNotNullParameter(missionID, "missionID");
        this.missionId = missionID;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schemaString = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkContext(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.traceId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.missionId = readString2 == null ? "" : readString2;
        x(q.INSTANCE.b(parcel));
        Serializable readSerializable = parcel.readSerializable();
        this.schemaAttrs = readSerializable instanceof HashMap ? (HashMap) readSerializable : null;
        String readString3 = parcel.readString();
        this.schemaString = readString3 == null ? "" : readString3;
        WinkExodus winkExodus = (WinkExodus) parcel.readParcelable(WinkExodus.class.getClassLoader());
        this.exodus = winkExodus == null ? new WinkExodus(null, 0L, 2, null) : winkExodus;
        DaTongParams daTongParams = (DaTongParams) parcel.readParcelable(DaTongParams.class.getClassLoader());
        this.dtParams = daTongParams == null ? new DaTongParams() : daTongParams;
        String readString4 = parcel.readString();
        this.refPgid = readString4 != null ? readString4 : "";
    }
}
