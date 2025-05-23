package com.tencent.qqnt.ntrelation.util;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.Intimate;
import com.tencent.qqnt.kernel.nativeinterface.MutualMark;
import com.tencent.qqnt.kernel.nativeinterface.ResourceInfo;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$ResourceInfo;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateData;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$UpdateMsg;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateIntimate;
import com.tencent.qqnt.ntrelation.protocol.ProfileUpdateMsg$updateMutualMark;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J.\u0010\u0015\u001a\u00020\b2\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0002J\"\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0006J(\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u00162\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0010j\b\u0012\u0004\u0012\u00020\u0006`\u0012R\u001a\u0010$\u001a\u00020\u00168\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010)\u001a\u00020%8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/d;", "", "Lcom/tencent/qqnt/ntrelation/util/d$a;", "convertData", "", "e", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/a;", "simpleInfo", "", "g", "", "value", "", "b", "byteArray", "a", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "Lkotlin/collections/ArrayList;", "infos", "flag", "f", "", "trace", "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/Intimate;", "intimate", "c", "result", tl.h.F, "ntIntimateSimpleInfoList", "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$UpdateMsg;", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "J", "getFLAG_MASK_INTIMACY", "()J", "FLAG_MASK_INTIMACY", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f360234a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final long FLAG_MASK_INTIMACY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b*\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bn\u0010oJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0002J \u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u000fj\b\u0012\u0004\u0012\u00020\u0000`\u00102\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0016\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010)\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0019\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b+\u0010\u001dR\"\u0010/\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b.\u0010\u001dR\"\u00102\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR\"\u00104\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b3\u0010\u001dR\"\u00107\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\"\u0010:\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\"\u0010>\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010=R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b?\u0010\u0015\"\u0004\b@\u0010=R\"\u0010E\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0013\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010=R\"\u0010M\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010Q\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010H\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR\"\u0010U\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u0019\u001a\u0004\bS\u0010\u001b\"\u0004\bT\u0010\u001dR\"\u0010Y\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u0013\u001a\u0004\bW\u0010\u0015\"\u0004\bX\u0010=R\"\u0010`\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010b\u001a\u00020F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010H\u001a\u0004\bb\u0010J\"\u0004\bc\u0010LR$\u0010g\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bd\u0010\u0013\u001a\u0004\be\u0010\u0015\"\u0004\bf\u0010=R\"\u0010j\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010[\u001a\u0004\b-\u0010]\"\u0004\bi\u0010_R\"\u0010m\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010\u0019\u001a\u0004\b*\u0010\u001b\"\u0004\bl\u0010\u001d\u00a8\u0006p"}, d2 = {"Lcom/tencent/qqnt/ntrelation/util/d$a;", "", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "k", "Lcom/tencent/qqnt/kernel/nativeinterface/MutualMark;", "mutualMark", "", "curOrderNum", tl.h.F, "Lcom/tencent/qqnt/ntrelation/protocol/ProfileUpdateMsg$updateMutualMark;", "i", "l", "", "json_str", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "", "b", "J", "g", "()J", "setType", "(J)V", "type", "c", "d", "setLevel", "level", "", UserInfo.SEX_FEMALE, "getCount", "()F", "setCount", "(F)V", "count", "e", "setContinue_days", "continue_days", "f", "setLast_action_time", "last_action_time", "getLast_change_time", "setLast_change_time", "last_change_time", "setIcon_status", "icon_status", "getIcon_status_end_time", "setIcon_status_end_time", "icon_status_end_time", "getSub_level", "setSub_level", "sub_level", "getIcon_static_url", "setIcon_static_url", "(Ljava/lang/String;)V", "icon_static_url", "getIcon_dynamic_url", "setIcon_dynamic_url", "icon_dynamic_url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getIcon_name", "setIcon_name", "icon_name", "", DomainData.DOMAIN_NAME, "Z", "getUser_close_flag", "()Z", "setUser_close_flag", "(Z)V", "user_close_flag", "o", "getHasRemindInContact", "setHasRemindInContact", "hasRemindInContact", "p", "getRemindAnimStartTime", "setRemindAnimStartTime", "remindAnimStartTime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getIconUrl", "setIconUrl", "iconUrl", "r", "I", "getMarkVersion", "()I", "setMarkVersion", "(I)V", "markVersion", ReportConstant.COSTREPORT_PREFIX, "isWearing", "setWearing", "t", "getIconFormat", "setIconFormat", "iconFormat", "u", "setOrderNum", "orderNum", "v", "setMarkFlag", "markFlag", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String TAG;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private long type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long level;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float count;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long continue_days;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long last_action_time;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private long last_change_time;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long icon_status;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long icon_status_end_time;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private long sub_level;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String icon_static_url;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String icon_dynamic_url;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String icon_name;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean user_close_flag;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private boolean hasRemindInContact;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private long remindAnimStartTime;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String iconUrl;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private int markVersion;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private boolean isWearing;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String iconFormat;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private int orderNum;

        /* renamed from: v, reason: collision with root package name and from kotlin metadata */
        private long markFlag;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.TAG = "ConvertClass";
            this.icon_static_url = "";
            this.icon_dynamic_url = "";
            this.icon_name = "";
            this.iconUrl = "";
        }

        private final a k(JSONObject json) {
            if (json == null) {
                return null;
            }
            a aVar = new a();
            aVar.type = json.optLong("type");
            aVar.level = json.optLong("level");
            aVar.count = (float) json.optDouble("count", 0.0d);
            aVar.continue_days = json.optLong("continue_days");
            aVar.last_action_time = json.optLong("last_action_time");
            aVar.last_change_time = json.optLong("last_change_time");
            aVar.icon_status = json.optLong("icon_status");
            aVar.icon_status_end_time = json.optLong("icon_status_end_time");
            aVar.sub_level = json.optLong("sub_level");
            aVar.hasRemindInContact = json.optBoolean("hasRemindInContact");
            String optString = json.optString("icon_static_url");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"icon_static_url\")");
            aVar.icon_static_url = optString;
            String optString2 = json.optString("icon_dynamic_url");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"icon_dynamic_url\")");
            aVar.icon_dynamic_url = optString2;
            String optString3 = json.optString("icon_name");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(\"icon_name\")");
            aVar.icon_name = optString3;
            aVar.user_close_flag = json.optBoolean("user_close_flag");
            String optString4 = json.optString("icon_url");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(\"icon_url\")");
            aVar.iconUrl = optString4;
            aVar.markVersion = json.optInt("mark_version");
            aVar.isWearing = json.optBoolean("is_wearing");
            aVar.orderNum = json.optInt("order_num");
            aVar.iconFormat = json.optString("icon_format");
            aVar.markFlag = json.optLong("mark_flag", 0L);
            return aVar;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
            }
            return this.continue_days;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
            }
            return this.icon_status;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
            }
            return this.last_action_time;
        }

        public final long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.level;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return ((Long) iPatchRedirector.redirect((short) 43, (Object) this)).longValue();
            }
            return this.markFlag;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
            }
            return this.orderNum;
        }

        public final long g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.type;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
        
            if (r0.intValue() == 1) goto L38;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a h(@NotNull MutualMark mutualMark, int curOrderNum) {
            long longValue;
            long longValue2;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                return (a) iPatchRedirector.redirect((short) 45, (Object) this, (Object) mutualMark, curOrderNum);
            }
            Intrinsics.checkNotNullParameter(mutualMark, "mutualMark");
            this.type = mutualMark.type;
            this.level = mutualMark.level;
            this.count = mutualMark.count;
            this.continue_days = mutualMark.continueDays;
            this.last_action_time = mutualMark.lastActionTime;
            Long l3 = mutualMark.lastChangTime;
            long j3 = 0;
            if (l3 == null) {
                longValue = 0;
            } else {
                longValue = l3.longValue();
            }
            this.last_change_time = longValue;
            this.icon_status = mutualMark.iconStatus;
            Long l16 = mutualMark.iconStatusEndTime;
            if (l16 == null) {
                longValue2 = 0;
            } else {
                longValue2 = l16.longValue();
            }
            this.icon_status_end_time = longValue2;
            this.sub_level = mutualMark.subLevel;
            ResourceInfo resourceInfo = mutualMark.resourceInfo;
            String str = "";
            if (resourceInfo != null) {
                String str2 = resourceInfo.iconStaticUrl;
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "it.iconStaticUrl?:\"\"");
                }
                this.icon_static_url = str2;
                String str3 = resourceInfo.iconDynamicUrl;
                if (str3 == null) {
                    str3 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "it.iconDynamicUrl?:\"\"");
                }
                this.icon_dynamic_url = str3;
                String str4 = resourceInfo.iconName;
                if (str4 == null) {
                    str4 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str4, "it.iconName?:\"\"");
                }
                this.icon_name = str4;
            }
            Integer num = mutualMark.closeFlag;
            int i3 = 0;
            if (num != null) {
                z16 = true;
            }
            z16 = false;
            this.user_close_flag = z16;
            this.hasRemindInContact = mutualMark.hasRemindInContact;
            Long l17 = mutualMark.remindAnimStartTime;
            if (l17 != null) {
                j3 = l17.longValue();
            }
            this.remindAnimStartTime = j3;
            String str5 = mutualMark.iconUrl;
            if (str5 == null) {
                str5 = "";
            }
            this.iconUrl = str5;
            Integer num2 = mutualMark.markVersion;
            if (num2 != null) {
                i3 = num2.intValue();
            }
            this.markVersion = i3;
            this.isWearing = mutualMark.isWearing;
            String str6 = mutualMark.iconFormat;
            if (str6 != null) {
                str = str6;
            }
            this.iconFormat = str;
            this.markFlag = mutualMark.markFlag;
            this.orderNum = curOrderNum;
            return this;
        }

        @NotNull
        public final ProfileUpdateMsg$updateMutualMark i(int curOrderNum) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
                return (ProfileUpdateMsg$updateMutualMark) iPatchRedirector.redirect((short) 46, (Object) this, curOrderNum);
            }
            ProfileUpdateMsg$updateMutualMark profileUpdateMsg$updateMutualMark = new ProfileUpdateMsg$updateMutualMark();
            ProfileUpdateMsg$ResourceInfo profileUpdateMsg$ResourceInfo = new ProfileUpdateMsg$ResourceInfo();
            profileUpdateMsg$updateMutualMark.type.set(this.type);
            profileUpdateMsg$updateMutualMark.level.set(this.level);
            profileUpdateMsg$updateMutualMark.count.set(this.count);
            profileUpdateMsg$updateMutualMark.continueDays.set(this.continue_days);
            profileUpdateMsg$updateMutualMark.lastActionTime.set(this.last_action_time);
            profileUpdateMsg$updateMutualMark.lastChangTime.set(this.last_change_time);
            profileUpdateMsg$updateMutualMark.iconStatus.set(this.icon_status);
            profileUpdateMsg$updateMutualMark.iconStatusEndTime.set(this.icon_status_end_time);
            profileUpdateMsg$updateMutualMark.subLevel.set(this.sub_level);
            profileUpdateMsg$ResourceInfo.iconStaticUrl.set(this.icon_static_url);
            profileUpdateMsg$ResourceInfo.iconDynamicUrl.set(this.icon_dynamic_url);
            profileUpdateMsg$ResourceInfo.iconName.set(this.icon_name);
            profileUpdateMsg$updateMutualMark.resourceInfo.set(profileUpdateMsg$ResourceInfo);
            profileUpdateMsg$updateMutualMark.closeFlag.set(this.user_close_flag ? 1 : 0);
            profileUpdateMsg$updateMutualMark.hasRemindInContact.set(this.hasRemindInContact);
            profileUpdateMsg$updateMutualMark.remindAnimStartTime.set(this.remindAnimStartTime);
            profileUpdateMsg$updateMutualMark.iconUrl.set(this.iconUrl);
            profileUpdateMsg$updateMutualMark.markVersion.set(this.markVersion);
            profileUpdateMsg$updateMutualMark.isWearing.set(this.isWearing);
            profileUpdateMsg$updateMutualMark.iconFormat.set(this.iconFormat);
            profileUpdateMsg$updateMutualMark.markFlag.set(this.markFlag);
            profileUpdateMsg$updateMutualMark.orderNum.set(curOrderNum);
            return profileUpdateMsg$updateMutualMark;
        }

        @NotNull
        public ArrayList<a> j(@NotNull String json_str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
                return (ArrayList) iPatchRedirector.redirect((short) 48, (Object) this, (Object) json_str);
            }
            Intrinsics.checkNotNullParameter(json_str, "json_str");
            ArrayList<a> arrayList = new ArrayList<>();
            try {
            } catch (JSONException e16) {
                QLog.e(this.TAG, 1, "toJsonString error:" + e16.getMessage());
            }
            if (TextUtils.isEmpty(json_str)) {
                return arrayList;
            }
            JSONArray jSONArray = new JSONArray(json_str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                a k3 = k(jSONArray.getJSONObject(i3));
                if (k3 != null) {
                    arrayList.add(k3);
                }
            }
            return arrayList;
        }

        @NotNull
        public final JSONObject l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
                return (JSONObject) iPatchRedirector.redirect((short) 47, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.type);
                jSONObject.put("level", this.level);
                jSONObject.put("count", this.count);
                jSONObject.put("continue_days", this.continue_days);
                jSONObject.put("last_action_time", this.last_action_time);
                jSONObject.put("last_change_time", this.last_change_time);
                jSONObject.put("icon_status", this.icon_status);
                jSONObject.put("icon_status_end_time", this.icon_status_end_time);
                jSONObject.put("sub_level", this.sub_level);
                jSONObject.put("hasRemindInContact", this.hasRemindInContact);
                jSONObject.put("icon_static_url", this.icon_static_url);
                jSONObject.put("icon_dynamic_url", this.icon_dynamic_url);
                jSONObject.put("icon_name", this.icon_name);
                jSONObject.put("user_close_flag", this.user_close_flag);
                jSONObject.put("icon_url", this.iconUrl);
                jSONObject.put("mark_version", this.markVersion);
                jSONObject.put("is_wearing", this.isWearing);
                jSONObject.put("order_num", this.orderNum);
                jSONObject.put("icon_format", this.iconFormat);
                jSONObject.put("mark_flag", this.markFlag);
            } catch (JSONException e16) {
                QLog.e(this.TAG, 1, "toJsonForStore error:" + e16.getMessage());
            }
            return jSONObject;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
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
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((a) t16).f()), Integer.valueOf(((a) t17).f()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37580);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f360234a = new d();
        TAG = "MutualMarkDataConvertUtil";
        FLAG_MASK_INTIMACY = 8L;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a(byte[] byteArray) {
        int length = byteArray.length;
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            if (i16 < 4) {
                i3 |= (byteArray[i16] & 255) << ((3 - i16) * 8);
            }
        }
        return i3;
    }

    private final byte[] b(int value) {
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(4 - i3) - 1] = (byte) ((value >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    private final boolean e(a convertData) {
        int g16 = (int) convertData.g();
        if (g16 == 1 || g16 == 2 || g16 == 3 || g16 == 26) {
            return true;
        }
        return false;
    }

    private final void f(ArrayList<NTMutualMarkEntity> infos, byte[] flag) {
        boolean contains$default;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        String replace$default7;
        if (infos == null) {
            return;
        }
        Iterator<NTMutualMarkEntity> it = infos.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "infos.iterator()");
        while (it.hasNext()) {
            NTMutualMarkEntity next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            NTMutualMarkEntity nTMutualMarkEntity = next;
            if (nTMutualMarkEntity.isWearing && !nTMutualMarkEntity.user_close_flag) {
                int b16 = com.tencent.qqnt.ntrelation.intimateinfo.manager.vip.a.b(nTMutualMarkEntity.uin, com.tencent.qqnt.ntrelation.intimateinfo.manager.vip.a.d((int) nTMutualMarkEntity.type), flag);
                int a16 = com.tencent.qqnt.ntrelation.intimateinfo.manager.vip.a.a(nTMutualMarkEntity.type, flag);
                if (QLog.isDebugVersion()) {
                    QLog.d(TAG, 4, "friendUin=" + nTMutualMarkEntity.uin + "getMutualMarkDisPlayInfoForNewVersion,type=" + nTMutualMarkEntity.type + ",isWearing=" + nTMutualMarkEntity.isWearing + ",iconUrl=" + nTMutualMarkEntity.iconUrl + ",iconFormat=" + nTMutualMarkEntity.iconFormat + ",alienationType=" + b16 + ",curSpecialType=" + a16);
                }
                if ((b16 != 0 || a16 != 0) && !TextUtils.isEmpty(nTMutualMarkEntity.iconFormat)) {
                    String str = nTMutualMarkEntity.iconFormat;
                    Intrinsics.checkNotNull(str);
                    nTMutualMarkEntity.iconUrl = str;
                    if (b16 != 0) {
                        replace$default7 = StringsKt__StringsJVMKt.replace$default(str, "{alienation}", String.valueOf(b16), false, 4, (Object) null);
                        nTMutualMarkEntity.iconUrl = replace$default7;
                    }
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) nTMutualMarkEntity.iconUrl, (CharSequence) "{alienation}", false, 2, (Object) null);
                    if (contains$default) {
                        replace$default6 = StringsKt__StringsJVMKt.replace$default(nTMutualMarkEntity.iconUrl, "{alienation}", String.valueOf(a16), false, 4, (Object) null);
                        nTMutualMarkEntity.iconUrl = replace$default6;
                    } else if (a16 != 0) {
                        replace$default = StringsKt__StringsJVMKt.replace$default(nTMutualMarkEntity.iconUrl, "/{level}", a16 + "/{level}", false, 4, (Object) null);
                        nTMutualMarkEntity.iconUrl = replace$default;
                    }
                    replace$default2 = StringsKt__StringsJVMKt.replace$default(nTMutualMarkEntity.iconUrl, "{level}", String.valueOf(nTMutualMarkEntity.level), false, 4, (Object) null);
                    replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "{sub_level}", String.valueOf(nTMutualMarkEntity.sub_level), false, 4, (Object) null);
                    replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "{style}", "0", false, 4, (Object) null);
                    replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "{size}", NtFaceConstant.SMALL, false, 4, (Object) null);
                    nTMutualMarkEntity.iconUrl = replace$default5;
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 4, "friendUin=" + nTMutualMarkEntity.uin + "getMutualMarkDisPlayInfoForNewVersion,type=" + nTMutualMarkEntity.type + " ,displayInfo=" + nTMutualMarkEntity.iconUrl);
                    }
                    if (QLog.isDebugVersion()) {
                        QLog.d(TAG, 1, "replace old VipUrl:" + nTMutualMarkEntity.icon_dynamic_url + " with new iconApngUrl:" + nTMutualMarkEntity.iconUrl);
                    }
                    nTMutualMarkEntity.icon_dynamic_url = nTMutualMarkEntity.iconUrl;
                }
                if (nTMutualMarkEntity.markVersion == 0 && !TextUtils.isEmpty(nTMutualMarkEntity.iconUrl)) {
                    nTMutualMarkEntity.icon_static_url = nTMutualMarkEntity.iconUrl;
                }
            } else {
                it.remove();
            }
        }
    }

    private final void g(com.tencent.qqnt.ntrelation.intimateinfo.bean.a simpleInfo) {
        simpleInfo.u(0);
        simpleInfo.v(0);
        simpleInfo.t(0);
        simpleInfo.w(0L);
        simpleInfo.r(Boolean.FALSE);
    }

    @Nullable
    public final com.tencent.qqnt.ntrelation.intimateinfo.bean.a c(@NotNull String trace, @NotNull String uid, @Nullable Intimate intimate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.ntrelation.intimateinfo.bean.a) iPatchRedirector.redirect((short) 4, this, trace, uid, intimate);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (intimate == null) {
            return null;
        }
        com.tencent.qqnt.ntrelation.intimateinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.intimateinfo.bean.a(null, null, 3, null);
        aVar.A(uid);
        aVar.B(c.f360229a.m(uid));
        h(trace, intimate, aVar);
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
            QLog.e(TAG, 1, "trace " + trace + " KernelDataToNTIntimateSimpleInfo " + aVar);
        }
        return aVar;
    }

    @Nullable
    public final ProfileUpdateMsg$UpdateMsg d(@NotNull String trace, @NotNull ArrayList<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> ntIntimateSimpleInfoList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ProfileUpdateMsg$UpdateMsg) iPatchRedirector.redirect((short) 6, (Object) this, (Object) trace, (Object) ntIntimateSimpleInfoList);
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(ntIntimateSimpleInfoList, "ntIntimateSimpleInfoList");
        if (ntIntimateSimpleInfoList.isEmpty()) {
            return null;
        }
        ProfileUpdateMsg$UpdateMsg profileUpdateMsg$UpdateMsg = new ProfileUpdateMsg$UpdateMsg();
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.qqnt.ntrelation.intimateinfo.bean.a> it = ntIntimateSimpleInfoList.iterator();
        while (it.hasNext()) {
            com.tencent.qqnt.ntrelation.intimateinfo.bean.a next = it.next();
            if (next != null && !TextUtils.isEmpty(next.getUid()) && !TextUtils.isEmpty(next.n())) {
                ProfileUpdateMsg$UpdateData profileUpdateMsg$UpdateData = new ProfileUpdateMsg$UpdateData();
                profileUpdateMsg$UpdateData.uid.set(next.getUid());
                profileUpdateMsg$UpdateData.uin.set(Long.parseLong(next.n()));
                ProfileUpdateMsg$updateIntimate profileUpdateMsg$updateIntimate = new ProfileUpdateMsg$updateIntimate();
                byte[] b16 = next.b();
                if (b16 != null) {
                    profileUpdateMsg$updateIntimate.iconFlag.set(f360234a.a(b16));
                }
                ArrayList arrayList2 = new ArrayList();
                String m3 = next.m();
                if (m3 != null) {
                    ArrayList<a> j3 = new a().j(m3);
                    if (j3.size() > 1) {
                        CollectionsKt__MutableCollectionsJVMKt.sortWith(j3, new b());
                    }
                    int size = j3.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList2.add(j3.get((j3.size() - i3) - 1).i(i3));
                    }
                    if (arrayList2.isEmpty()) {
                        ProfileUpdateMsg$updateMutualMark profileUpdateMsg$updateMutualMark = new ProfileUpdateMsg$updateMutualMark();
                        profileUpdateMsg$updateMutualMark.type.set(-1L);
                        profileUpdateMsg$updateMutualMark.iconStatus.set(1L);
                        arrayList2.add(profileUpdateMsg$updateMutualMark);
                    }
                }
                profileUpdateMsg$updateIntimate.mutual.set(arrayList2);
                Boolean p16 = next.p();
                if (p16 != null) {
                    profileUpdateMsg$updateIntimate.ssListenTogetherOpen.set(p16.booleanValue());
                }
                profileUpdateMsg$UpdateData.intimate.set(profileUpdateMsg$updateIntimate);
                arrayList.add(profileUpdateMsg$UpdateData);
                QLog.e(TAG, 1, "trace " + trace + " NTIntimateSimpleInfoToKernelData " + next);
            }
        }
        profileUpdateMsg$UpdateMsg.datas.set(arrayList);
        return profileUpdateMsg$UpdateMsg;
    }

    public final void h(@NotNull String trace, @Nullable Intimate intimate, @NotNull com.tencent.qqnt.ntrelation.intimateinfo.bean.a result) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, trace, intimate, result);
            return;
        }
        Intrinsics.checkNotNullParameter(trace, "trace");
        Intrinsics.checkNotNullParameter(result, "result");
        if (intimate != null) {
            JSONArray jSONArray = new JSONArray();
            d dVar = f360234a;
            result.s(dVar.b(intimate.iconFlag));
            ArrayList<MutualMark> mutual = intimate.mutual;
            if (mutual != null) {
                Intrinsics.checkNotNullExpressionValue(mutual, "mutual");
                dVar.g(result);
                int size = mutual.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (mutual.get(i3) != null) {
                        a aVar = new a();
                        MutualMark mutualMark = mutual.get(i3);
                        Intrinsics.checkNotNullExpressionValue(mutualMark, "it[i]");
                        a h16 = aVar.h(mutualMark, (mutual.size() - i3) - 1);
                        if ((f360234a.e(h16) || (h16.e() & FLAG_MASK_INTIMACY) != 0) && h16.b() != 1) {
                            result.u((int) h16.d());
                            result.v((int) h16.g());
                            result.t((int) h16.a());
                            result.w(h16.c());
                            if (h16.b() == 1) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            result.r(Boolean.valueOf(z16));
                        }
                        jSONArray.mo162put(h16.l());
                    }
                }
                ArrayList<NTMutualMarkEntity> arrayList = new ArrayList<>();
                int size2 = mutual.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    NTMutualMarkEntity nTMutualMarkEntity = new NTMutualMarkEntity();
                    String uid = result.getUid();
                    String n3 = result.n();
                    MutualMark mutualMark2 = mutual.get(i16);
                    Intrinsics.checkNotNullExpressionValue(mutualMark2, "it[i]");
                    arrayList.add(0, nTMutualMarkEntity.mergeFromMutualMark(uid, n3, mutualMark2, (mutual.size() - i16) - 1));
                }
                f360234a.f(arrayList, result.b());
                result.y(arrayList);
            }
            result.x(Boolean.valueOf(intimate.isListenTogetherOpen));
            if (jSONArray.length() > 0) {
                str = jSONArray.toString();
            } else {
                str = "";
            }
            result.z(str);
            if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getIsLogOpen()) {
                QLog.e(TAG, 1, "trace " + trace + " userIntimateUpdateNTIntimateSimpleInfo " + result);
            }
        }
    }
}
