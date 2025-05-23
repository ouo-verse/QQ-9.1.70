package com.tencent.mobileqq.wink.picker.qzone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.utils.ai;
import com.tencent.mobileqq.wink.utils.ao;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import cooperation.qzone.media.QZoneMediaBusiness;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.vip.pb.TianShuAccess;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001dR\u0016\u0010 \u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001dR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001c0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010&\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/n;", "", "Lcom/tencent/mobileqq/wink/picker/qzone/n$a;", DownloadInfo.spKey_Config, "c", "Landroid/content/Intent;", "intent", "", "g", "", "d", "", "j", tl.h.F, "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "f", "i", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "actionId", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "tianShuConfigMap", "", "Ljava/lang/String;", "photoRecommendEnableString", "photoRecommendMoreString", "photoRecommendNothingString", "", "Ljava/util/Set;", "moodBusinessSet", "albumBusinessSet", "Lcom/tencent/mobileqq/wink/picker/qzone/n$a;", "defaultConfig", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f325197a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, RecommendItemConfig> tianShuConfigMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String photoRecommendEnableString = "\u5f00\u542f\u63a8\u8350\u56de\u5fc6\u5f71\u96c6";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String photoRecommendMoreString = "\u4e3a\u4f60\u751f\u6210\u591a\u7bc7\u56de\u5fc6";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String photoRecommendNothingString = "\u6682\u65e0\u53ef\u751f\u6210\u56de\u5fc6";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> moodBusinessSet;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> albumBusinessSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final RecommendItemConfig defaultConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u0010-J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010'\u001a\u0004\b\u000b\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/n$a;", "", "", "j", "i", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", TuxUIConstants.POP_BTN_TEXT, "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "k", "(Ljava/lang/Object;)V", "bgUrl", "g", "p", "title", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "desc", "e", "f", "o", QZoneDTLoginReporter.SCHEMA, tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, DomainData.DOMAIN_NAME, "iADId", "I", "()I", "setAdID", "(I)V", "adID", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qzone.n$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class RecommendItemConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String btnText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private Object bgUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String title;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String desc;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String schema;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String traceInfo;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String iADId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private int adID;

        public RecommendItemConfig() {
            this(null, null, null, null, null, null, null, 0, 255, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getAdID() {
            return this.adID;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Object getBgUrl() {
            return this.bgUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getBtnText() {
            return this.btnText;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getIADId() {
            return this.iADId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecommendItemConfig)) {
                return false;
            }
            RecommendItemConfig recommendItemConfig = (RecommendItemConfig) other;
            if (Intrinsics.areEqual(this.btnText, recommendItemConfig.btnText) && Intrinsics.areEqual(this.bgUrl, recommendItemConfig.bgUrl) && Intrinsics.areEqual(this.title, recommendItemConfig.title) && Intrinsics.areEqual(this.desc, recommendItemConfig.desc) && Intrinsics.areEqual(this.schema, recommendItemConfig.schema) && Intrinsics.areEqual(this.traceInfo, recommendItemConfig.traceInfo) && Intrinsics.areEqual(this.iADId, recommendItemConfig.iADId) && this.adID == recommendItemConfig.adID) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getSchema() {
            return this.schema;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getTraceInfo() {
            return this.traceInfo;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.btnText.hashCode() * 31;
            Object obj = this.bgUrl;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            return ((((((((((((hashCode2 + hashCode) * 31) + this.title.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.schema.hashCode()) * 31) + this.traceInfo.hashCode()) * 31) + this.iADId.hashCode()) * 31) + this.adID;
        }

        public final boolean i() {
            boolean contains$default;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.schema, (CharSequence) "mqqapi://qcircle/openqqpublish?target=22", false, 2, (Object) null);
            return contains$default;
        }

        public final boolean j() {
            boolean z16;
            boolean z17;
            boolean z18;
            if (this.schema.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.btnText.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    if (this.desc.length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final void k(@Nullable Object obj) {
            this.bgUrl = obj;
        }

        public final void l(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.btnText = str;
        }

        public final void m(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final void n(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iADId = str;
        }

        public final void o(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.schema = str;
        }

        public final void p(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void q(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.traceInfo = str;
        }

        @NotNull
        public String toString() {
            return "RecommendItemConfig(btnText=" + this.btnText + ", bgUrl=" + this.bgUrl + ", title=" + this.title + ", desc=" + this.desc + ", schema=" + this.schema + ", traceInfo=" + this.traceInfo + ", iADId=" + this.iADId + ", adID=" + this.adID + ")";
        }

        public RecommendItemConfig(@NotNull String btnText, @Nullable Object obj, @NotNull String title, @NotNull String desc, @NotNull String schema, @NotNull String traceInfo, @NotNull String iADId, int i3) {
            Intrinsics.checkNotNullParameter(btnText, "btnText");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(schema, "schema");
            Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
            Intrinsics.checkNotNullParameter(iADId, "iADId");
            this.btnText = btnText;
            this.bgUrl = obj;
            this.title = title;
            this.desc = desc;
            this.schema = schema;
            this.traceInfo = traceInfo;
            this.iADId = iADId;
            this.adID = i3;
        }

        public /* synthetic */ RecommendItemConfig(String str, Object obj, String str2, String str3, String str4, String str5, String str6, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? null : obj, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? "" : str4, (i16 & 32) != 0 ? "" : str5, (i16 & 64) == 0 ? str6 : "", (i16 & 128) != 0 ? 0 : i3);
        }
    }

    static {
        Set<String> mutableSetOf;
        Set<String> mutableSetOf2;
        String businessName = QZoneMediaBusiness.QZONE_MYSHUOSHUO_LIST_PHOTO.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName, "QZONE_MYSHUOSHUO_LIST_PHOTO.businessName");
        String businessName2 = QZoneMediaBusiness.QZONE_MYSHUOSHUO_LIST_VIDEO.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName2, "QZONE_MYSHUOSHUO_LIST_VIDEO.businessName");
        String businessName3 = QZoneMediaBusiness.QZONE_SHUOSHUO_UPLOAD_PIC.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName3, "QZONE_SHUOSHUO_UPLOAD_PIC.businessName");
        String businessName4 = QZoneMediaBusiness.QZONE_SHUOSHUO_MAKE_VIDEO.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName4, "QZONE_SHUOSHUO_MAKE_VIDEO.businessName");
        String businessName5 = QZoneMediaBusiness.QZONE_SHUOSHUO_LONGPIC.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName5, "QZONE_SHUOSHUO_LONGPIC.businessName");
        String businessName6 = QZoneMediaBusiness.QZONE_SHUOSHUO_PERVIEW.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName6, "QZONE_SHUOSHUO_PERVIEW.businessName");
        String businessName7 = QZoneMediaBusiness.QZONE_PLUS_ICON_ENTRANCE.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName7, "QZONE_PLUS_ICON_ENTRANCE.businessName");
        String businessName8 = QZoneMediaBusiness.QZONE_PANEL_CAMERA.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName8, "QZONE_PANEL_CAMERA.businessName");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(businessName, businessName2, businessName3, businessName4, businessName5, businessName6, businessName7, businessName8);
        moodBusinessSet = mutableSetOf;
        String businessName9 = QZoneMediaBusiness.QZONE_PANEL_ALBUM.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName9, "QZONE_PANEL_ALBUM.businessName");
        String businessName10 = QZoneMediaBusiness.QZONE_ALBUM_LIST.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName10, "QZONE_ALBUM_LIST.businessName");
        String businessName11 = QZoneMediaBusiness.QZONE_ALBUM_LIST_ONLY_VIDEO.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName11, "QZONE_ALBUM_LIST_ONLY_VIDEO.businessName");
        String businessName12 = QZoneMediaBusiness.QZONE_ALBUM_DETAIL.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName12, "QZONE_ALBUM_DETAIL.businessName");
        String businessName13 = QZoneMediaBusiness.QZONE_ALBUM_UPLOAD_PIC.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName13, "QZONE_ALBUM_UPLOAD_PIC.businessName");
        String businessName14 = QZoneMediaBusiness.QZONE_VIDEO_ALBUM.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName14, "QZONE_VIDEO_ALBUM.businessName");
        String businessName15 = QZoneMediaBusiness.QZONE_ALBUM_PERVIEW.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName15, "QZONE_ALBUM_PERVIEW.businessName");
        String businessName16 = QZoneMediaBusiness.QZONE_ALBUMX_UPLOAD_ALBUM.getBusinessName();
        Intrinsics.checkNotNullExpressionValue(businessName16, "QZONE_ALBUMX_UPLOAD_ALBUM.businessName");
        mutableSetOf2 = SetsKt__SetsKt.mutableSetOf(businessName9, businessName10, businessName11, businessName12, businessName13, businessName14, businessName15, businessName16);
        albumBusinessSet = mutableSetOf2;
        defaultConfig = new RecommendItemConfig("\u4e00\u952e\u4f53\u9a8c", "https://tianshu.gtimg.cn/tianshu/1730363555894.png", "AI\u5999\u7ed8", "\u4f53\u9a8c\u66f4\u591a\u6709\u8da3\u73a9\u6cd5", "mqqapi://qcircle/openqqpublish?target=2&inner_jump=1", null, null, 0, 224, null);
    }

    n() {
    }

    private final RecommendItemConfig c(RecommendItemConfig config) {
        boolean z16;
        if (!com.tencent.mobileqq.wink.editor.util.h.f322638a.e()) {
            w53.b.f("QZoneRecommendFirstItemManager", "buildPhotoRecommendConfig: recommend not enable");
            return defaultConfig;
        }
        if (((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getLocalPhotoScanAuthorizeSwitch()) {
            String coverPath = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getFirstVideoFeedCoverPath();
            Intrinsics.checkNotNullExpressionValue(coverPath, "coverPath");
            if (coverPath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                config.k(Integer.valueOf(R.drawable.ntf));
                config.m(photoRecommendNothingString);
            } else {
                if (FileUtils.fileExists(coverPath)) {
                    config.k(coverPath);
                } else {
                    config.k(Integer.valueOf(R.drawable.ntf));
                }
                config.m(photoRecommendMoreString);
            }
        } else {
            config.k(Integer.valueOf(R.drawable.ntf));
            config.m(photoRecommendEnableString);
        }
        w53.b.f("QZoneRecommendFirstItemManager", "buildPhotoRecommendConfig: " + config.getAdID());
        return config;
    }

    private final int d(Intent intent) {
        boolean contains;
        boolean contains2;
        String stringExtra = intent.getStringExtra("xsj_ref_pgid");
        w53.b.f("QZoneRecommendFirstItemManager", "getAdID: " + stringExtra);
        contains = CollectionsKt___CollectionsKt.contains(moodBusinessSet, stringExtra);
        if (!contains) {
            contains2 = CollectionsKt___CollectionsKt.contains(albumBusinessSet, stringExtra);
            if (contains2) {
                return 1356;
            }
            return -1;
        }
        return 1357;
    }

    private final List<TianShuAdPosItemData> f() {
        List<TianShuAdPosItemData> mutableListOf;
        try {
            TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
            tianShuAdPosItemData.mNeedCnt = 1;
            tianShuAdPosItemData.mPosId = 1356;
            Unit unit = Unit.INSTANCE;
            TianShuAdPosItemData tianShuAdPosItemData2 = new TianShuAdPosItemData();
            tianShuAdPosItemData2.mNeedCnt = 1;
            tianShuAdPosItemData2.mPosId = 1357;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(tianShuAdPosItemData, tianShuAdPosItemData2);
            return mutableListOf;
        } catch (Throwable th5) {
            w53.b.c("QZoneRecommendFirstItemManager", "getTianShuRequestList: " + th5);
            return null;
        }
    }

    private final boolean g(Intent intent) {
        return Intrinsics.areEqual(com.tencent.mobileqq.wink.schema.d.f326305a.e(intent).get(QCircleScheme.AttrQQPublish.INNER_JUMP), "1");
    }

    private final void h() {
        boolean z16;
        boolean z17;
        Map<String, String> a16 = ao.f326683a.a(ai.f326672a.b());
        if (a16 != null) {
            String str = a16.get("nothing");
            boolean z18 = false;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                photoRecommendNothingString = String.valueOf(a16.get("nothing"));
            }
            String str2 = a16.get("more");
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                photoRecommendMoreString = String.valueOf(a16.get("more"));
            }
            String str3 = a16.get("enable");
            if (str3 == null || str3.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                photoRecommendEnableString = String.valueOf(a16.get("enable"));
            }
        }
    }

    private final void j() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qzone.l
            @Override // java.lang.Runnable
            public final void run() {
                n.k();
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k() {
        List<TianShuAdPosItemData> f16 = f325197a.f();
        if (f16 == null) {
            return;
        }
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(f16, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.wink.picker.qzone.m
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                n.l(z16, getAdsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        w53.b.f("QZoneRecommendFirstItemManager", "loadTianShuConfig: code: " + getAdsRsp.code.get() + ", size: " + getAdsRsp.mapAds.size());
        if (getAdsRsp.code.get() == 0 && !getAdsRsp.mapAds.isEmpty()) {
            HashMap hashMap = new HashMap();
            int size = getAdsRsp.mapAds.size();
            int i3 = 0;
            while (i3 < size) {
                int i16 = size;
                RecommendItemConfig recommendItemConfig = new RecommendItemConfig(null, null, null, null, null, null, null, 0, 255, null);
                TianShuAccess.RspEntry rspEntry = getAdsRsp.mapAds.get(i3);
                Iterator<TianShuAccess.AdItem> it = rspEntry.value.get().lst.get().iterator();
                if (it.hasNext()) {
                    TianShuAccess.AdItem next = it.next();
                    String str = next.traceinfo.get();
                    Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
                    recommendItemConfig.q(str);
                    recommendItemConfig.n(String.valueOf(next.iAdId.get()));
                    for (TianShuAccess.MapEntry mapEntry : next.argList.get()) {
                        String value = mapEntry.value.get();
                        String str2 = mapEntry.key.get();
                        if (str2 != null) {
                            switch (str2.hashCode()) {
                                case -1377687758:
                                    if (str2.equals("button")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        recommendItemConfig.l(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 96858:
                                    if (str2.equals("ark")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        recommendItemConfig.o(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 99346:
                                    if (str2.equals(SecretUtils.DES)) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        recommendItemConfig.m(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 110986:
                                    if (str2.equals("pic")) {
                                        recommendItemConfig.k(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3373707:
                                    if (str2.equals("name")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        recommendItemConfig.p(value);
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                    w53.b.f("QZoneRecommendFirstItemManager", "loadTianShuConfig: " + recommendItemConfig.getAdID());
                }
                hashMap.put(Integer.valueOf(rspEntry.key.get()), recommendItemConfig);
                i3++;
                size = i16;
            }
            ConcurrentHashMap<Integer, RecommendItemConfig> concurrentHashMap = tianShuConfigMap;
            concurrentHashMap.clear();
            concurrentHashMap.putAll(hashMap);
        }
    }

    @NotNull
    public final RecommendItemConfig e(@Nullable Context context) {
        if (!(context instanceof Activity)) {
            w53.b.c("QZoneRecommendFirstItemManager", "getShowInfo: context is not activity");
            return new RecommendItemConfig(null, null, null, null, null, null, null, 0, 255, null);
        }
        Intent intent = ((Activity) context).getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "context.intent");
        RecommendItemConfig recommendItemConfig = tianShuConfigMap.get(Integer.valueOf(d(intent)));
        boolean z16 = false;
        if (recommendItemConfig != null && recommendItemConfig.j()) {
            z16 = true;
        }
        if (z16) {
            if (recommendItemConfig.i()) {
                return c(recommendItemConfig);
            }
            return recommendItemConfig;
        }
        return defaultConfig;
    }

    public final void i() {
        j();
        h();
    }

    public final boolean m(@Nullable Context context) {
        if (!(context instanceof Activity)) {
            w53.b.c("QZoneRecommendFirstItemManager", "needShowOnPicker: context is not activity");
            return false;
        }
        Activity activity = (Activity) context;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "context.intent");
        if (g(intent)) {
            return false;
        }
        Intent intent2 = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent2, "context.intent");
        if (d(intent2) == -1) {
            return false;
        }
        w53.b.f("QZoneRecommendFirstItemManager", "needShowOnPicker: recommendEnable: " + com.tencent.mobileqq.wink.editor.util.h.f322638a.e());
        RecommendItemConfig recommendItemConfig = defaultConfig;
        w53.b.f("QZoneRecommendFirstItemManager", "needShowOnPicker: defaultConfig: " + recommendItemConfig.getAdID());
        return recommendItemConfig.j();
    }

    public final void n(@NotNull RecommendItemConfig config, int actionId) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (Intrinsics.areEqual(config, defaultConfig)) {
            return;
        }
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mAppId = "tianshu.247";
        tianShuReportData.mPageId = "tianshu.247";
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mTraceId = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + tianShuReportData.mOperTime;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mTriggerInfo = config.getTraceInfo();
        tianShuReportData.mItemId = config.getIADId();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }
}
