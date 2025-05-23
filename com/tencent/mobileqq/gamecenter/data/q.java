package com.tencent.mobileqq.gamecenter.data;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 R2\u00020\u0001:\nRY\u000f\u0013\u0011\u0012\u0010\u0014\u001c\u001aB\u0007\u00a2\u0006\u0004\b]\u0010^J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\rJ\u0006\u0010\u0017\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0002R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR$\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q;", "", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", ReportConstant.COSTREPORT_PREFIX, "o", "u", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", BdhLogUtil.LogTag.Tag_Conn, "c", "g", "e", "f", "d", tl.h.F, HippyTKDListViewAdapter.X, "v", "y", "", "w", "j", "k", "i", "l", "Lcom/tencent/mobileqq/gamecenter/data/q$j;", "taskType", "Lcom/tencent/mobileqq/gamecenter/data/q$j;", "B", "()Lcom/tencent/mobileqq/gamecenter/data/q$j;", "L", "(Lcom/tencent/mobileqq/gamecenter/data/q$j;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$i;", "promotionAd", "Lcom/tencent/mobileqq/gamecenter/data/q$i;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Lcom/tencent/mobileqq/gamecenter/data/q$i;", "J", "(Lcom/tencent/mobileqq/gamecenter/data/q$i;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$g;", QCircleDaTongConstant.ElementParamValue.GIFT, "Lcom/tencent/mobileqq/gamecenter/data/q$g;", "p", "()Lcom/tencent/mobileqq/gamecenter/data/q$g;", "H", "(Lcom/tencent/mobileqq/gamecenter/data/q$g;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$e;", "cloudGame", "Lcom/tencent/mobileqq/gamecenter/data/q$e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/gamecenter/data/q$e;", "G", "(Lcom/tencent/mobileqq/gamecenter/data/q$e;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$h;", "messageNotice", "Lcom/tencent/mobileqq/gamecenter/data/q$h;", "t", "()Lcom/tencent/mobileqq/gamecenter/data/q$h;", "I", "(Lcom/tencent/mobileqq/gamecenter/data/q$h;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$d;", "taskStatus", "Lcom/tencent/mobileqq/gamecenter/data/q$d;", "getTaskStatus", "()Lcom/tencent/mobileqq/gamecenter/data/q$d;", "K", "(Lcom/tencent/mobileqq/gamecenter/data/q$d;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$c;", "batterPassTask", "Lcom/tencent/mobileqq/gamecenter/data/q$c;", "getBatterPassTask", "()Lcom/tencent/mobileqq/gamecenter/data/q$c;", "E", "(Lcom/tencent/mobileqq/gamecenter/data/q$c;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$b;", "batterPassProgress", "Lcom/tencent/mobileqq/gamecenter/data/q$b;", "a", "()Lcom/tencent/mobileqq/gamecenter/data/q$b;", "D", "(Lcom/tencent/mobileqq/gamecenter/data/q$b;)V", "Lcom/tencent/mobileqq/gamecenter/data/q$a;", "battlePassBottom", "Lcom/tencent/mobileqq/gamecenter/data/q$a;", "b", "()Lcom/tencent/mobileqq/gamecenter/data/q$a;", UserInfo.SEX_FEMALE, "(Lcom/tencent/mobileqq/gamecenter/data/q$a;)V", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class q {

    @SerializedName("batterPassProgress")
    @Nullable
    private b batterPassProgress;

    @SerializedName("batterPassTask")
    @Nullable
    private c batterPassTask;

    @SerializedName("battlePassBottom")
    @Nullable
    private a battlePassBottom;

    @SerializedName("cloudGame")
    @Nullable
    private e cloudGame;

    @SerializedName(QCircleDaTongConstant.ElementParamValue.GIFT)
    @Nullable
    private g gift;

    @SerializedName("messageNotice")
    @Nullable
    private h messageNotice;

    @SerializedName("promotionAd")
    @Nullable
    private i promotionAd;

    @SerializedName("taskStatus")
    @Nullable
    private d taskStatus;

    @SerializedName("taskType")
    @Nullable
    private j taskType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$a;", "", "", "expItem", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "iconUrl", "c", tl.h.F, "imgPath", "d", "i", "prizeNameLevel", "e", "j", "desc", "a", "f", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a {

        @SerializedName("expItem")
        @NotNull
        private String expItem = "";

        @SerializedName("iconUrl")
        @NotNull
        private String iconUrl = "";

        @SerializedName("imgPath")
        @NotNull
        private String imgPath = "";

        @SerializedName("prizeNameLevel")
        @NotNull
        private String prizeNameLevel = "";

        @SerializedName("desc")
        @NotNull
        private String desc = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getExpItem() {
            return this.expItem;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getPrizeNameLevel() {
            return this.prizeNameLevel;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expItem = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgPath = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.prizeNameLevel = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$b;", "", "", "levelIconUrl", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "imgPath", "b", tl.h.F, "", "curLevel", "I", "a", "()I", "g", "(I)V", "progress", "d", "j", "", "isAdvancedType", "Z", "e", "()Z", "f", "(Z)V", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b {

        @SerializedName("curLevel")
        private int curLevel;

        @SerializedName("isAdvancedType")
        private boolean isAdvancedType;

        @SerializedName("progress")
        private int progress;

        @SerializedName("levelIconUrl")
        @NotNull
        private String levelIconUrl = "";

        @SerializedName("imgPath")
        @NotNull
        private String imgPath = "";

        /* renamed from: a, reason: from getter */
        public final int getCurLevel() {
            return this.curLevel;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getLevelIconUrl() {
            return this.levelIconUrl;
        }

        /* renamed from: d, reason: from getter */
        public final int getProgress() {
            return this.progress;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsAdvancedType() {
            return this.isAdvancedType;
        }

        public final void f(boolean z16) {
            this.isAdvancedType = z16;
        }

        public final void g(int i3) {
            this.curLevel = i3;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgPath = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.levelIconUrl = str;
        }

        public final void j(int i3) {
            this.progress = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$c;", "", "", "desc", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "taskName", "d", "i", "expItem", "c", tl.h.F, "", "curExp", "I", "a", "()I", "f", "(I)V", "totalExp", "e", "j", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c {

        @SerializedName("curExp")
        private int curExp;

        @SerializedName("totalExp")
        private int totalExp;

        @SerializedName("desc")
        @NotNull
        private String desc = "";

        @SerializedName("taskName")
        @NotNull
        private String taskName = "";

        @SerializedName("expItem")
        @NotNull
        private String expItem = "";

        /* renamed from: a, reason: from getter */
        public final int getCurExp() {
            return this.curExp;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getExpItem() {
            return this.expItem;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getTaskName() {
            return this.taskName;
        }

        /* renamed from: e, reason: from getter */
        public final int getTotalExp() {
            return this.totalExp;
        }

        public final void f(int i3) {
            this.curExp = i3;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.desc = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.expItem = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.taskName = str;
        }

        public final void j(int i3) {
            this.totalExp = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$d;", "", "", "status", "I", "b", "()I", "d", "(I)V", "", WadlProxyConsts.KEY_JUMP_URL, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class d {

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private String jumpUrl = "";

        @SerializedName("status")
        private int status;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        /* renamed from: b, reason: from getter */
        public final int getStatus() {
            return this.status;
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }

        public final void d(int i3) {
            this.status = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$e;", "", "", "appid", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "d", "i", "icon", "b", "g", "text", "e", "j", "imgPath", "c", tl.h.F, "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e {

        @SerializedName("appid")
        @NotNull
        private String appid = "";

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private String jumpUrl = "";

        @SerializedName("icon")
        @NotNull
        private String icon = "";

        @SerializedName("text")
        @NotNull
        private String text = "";

        @SerializedName("imgPath")
        @NotNull
        private String imgPath = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppid() {
            return this.appid;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appid = str;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgPath = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$g;", "", "", "icon", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "", "count", "J", "b", "()J", "i", "(J)V", WadlProxyConsts.KEY_JUMP_URL, "e", "l", "appid", "a", tl.h.F, "text", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "imgPath", "d", "k", "", "urlType", "I", "g", "()I", DomainData.DOMAIN_NAME, "(I)V", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class g {

        @SerializedName("count")
        private long count;

        @SerializedName("urlType")
        private int urlType;

        @SerializedName("icon")
        @NotNull
        private String icon = "";

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private String jumpUrl = "";

        @SerializedName("appid")
        @NotNull
        private String appid = "";

        @SerializedName("text")
        @NotNull
        private String text = "";

        @SerializedName("imgPath")
        @NotNull
        private String imgPath = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppid() {
            return this.appid;
        }

        /* renamed from: b, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: g, reason: from getter */
        public final int getUrlType() {
            return this.urlType;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appid = str;
        }

        public final void i(long j3) {
            this.count = j3;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.icon = str;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgPath = str;
        }

        public final void l(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }

        public final void m(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final void n(int i3) {
            this.urlType = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$h;", "", "", "msg", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "getUniqueId", "g", WadlProxyConsts.KEY_JUMP_URL, "b", "e", "id", "a", "d", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class h {

        @SerializedName("msg")
        @NotNull
        private String msg = "";

        @SerializedName(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID)
        @NotNull
        private String uniqueId = "";

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private String jumpUrl = "";

        @SerializedName("id")
        @NotNull
        private String id = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        public final void d(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void e(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.msg = str;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.uniqueId = str;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$i;", "", "", "pic", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", WadlProxyConsts.KEY_JUMP_URL, "d", "i", "", "type", "I", "getType", "()I", "k", "(I)V", "imgPath", "c", tl.h.F, "appid", "a", "f", "id", "b", "g", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class i {

        @SerializedName("type")
        private int type;

        @SerializedName("pic")
        @NotNull
        private String pic = "";

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private String jumpUrl = "";

        @SerializedName("imgPath")
        @NotNull
        private String imgPath = "";

        @SerializedName("appid")
        @NotNull
        private String appid = "";

        @SerializedName("id")
        @NotNull
        private String id = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppid() {
            return this.appid;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getImgPath() {
            return this.imgPath;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getPic() {
            return this.pic;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appid = str;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imgPath = str;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.jumpUrl = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pic = str;
        }

        public final void k(int i3) {
            this.type = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/data/q$j;", "", "", "type", "I", "a", "()I", "b", "(I)V", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class j {

        @SerializedName("type")
        private int type;

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void b(int i3) {
            this.type = i3;
        }
    }

    @NotNull
    public final String A() {
        String imgPath;
        i iVar = this.promotionAd;
        if (iVar == null || (imgPath = iVar.getImgPath()) == null) {
            return "";
        }
        return imgPath;
    }

    @Nullable
    /* renamed from: B, reason: from getter */
    public final j getTaskType() {
        return this.taskType;
    }

    public final int C() {
        d dVar = this.taskStatus;
        if (dVar != null) {
            return dVar.getStatus();
        }
        return 0;
    }

    public final void D(@Nullable b bVar) {
        this.batterPassProgress = bVar;
    }

    public final void E(@Nullable c cVar) {
        this.batterPassTask = cVar;
    }

    public final void F(@Nullable a aVar) {
        this.battlePassBottom = aVar;
    }

    public final void G(@Nullable e eVar) {
        this.cloudGame = eVar;
    }

    public final void H(@Nullable g gVar) {
        this.gift = gVar;
    }

    public final void I(@Nullable h hVar) {
        this.messageNotice = hVar;
    }

    public final void J(@Nullable i iVar) {
        this.promotionAd = iVar;
    }

    public final void K(@Nullable d dVar) {
        this.taskStatus = dVar;
    }

    public final void L(@Nullable j jVar) {
        this.taskType = jVar;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final b getBatterPassProgress() {
        return this.batterPassProgress;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final a getBattlePassBottom() {
        return this.battlePassBottom;
    }

    @NotNull
    public final String c() {
        String jumpUrl;
        d dVar = this.taskStatus;
        if (dVar == null || (jumpUrl = dVar.getJumpUrl()) == null) {
            return "";
        }
        return jumpUrl;
    }

    public final int d() {
        c cVar = this.batterPassTask;
        if (cVar != null) {
            return cVar.getCurExp();
        }
        return 0;
    }

    @NotNull
    public final String e() {
        String desc;
        c cVar = this.batterPassTask;
        if (cVar == null || (desc = cVar.getDesc()) == null) {
            return "";
        }
        return desc;
    }

    @NotNull
    public final String f() {
        String expItem;
        c cVar = this.batterPassTask;
        if (cVar == null || (expItem = cVar.getExpItem()) == null) {
            return "";
        }
        return expItem;
    }

    @NotNull
    public final String g() {
        String taskName;
        c cVar = this.batterPassTask;
        if (cVar == null || (taskName = cVar.getTaskName()) == null) {
            return "";
        }
        return taskName;
    }

    public final int h() {
        c cVar = this.batterPassTask;
        if (cVar != null) {
            return cVar.getTotalExp();
        }
        return 0;
    }

    @NotNull
    public final String i() {
        String desc;
        a aVar = this.battlePassBottom;
        if (aVar == null || (desc = aVar.getDesc()) == null) {
            return "";
        }
        return desc;
    }

    @NotNull
    public final String j() {
        String expItem;
        a aVar = this.battlePassBottom;
        if (aVar == null || (expItem = aVar.getExpItem()) == null) {
            return "";
        }
        return expItem;
    }

    @NotNull
    public final String k() {
        String imgPath;
        a aVar = this.battlePassBottom;
        if (aVar == null || (imgPath = aVar.getImgPath()) == null) {
            return "";
        }
        return imgPath;
    }

    @NotNull
    public final String l() {
        String prizeNameLevel;
        a aVar = this.battlePassBottom;
        if (aVar == null || (prizeNameLevel = aVar.getPrizeNameLevel()) == null) {
            return "";
        }
        return prizeNameLevel;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final e getCloudGame() {
        return this.cloudGame;
    }

    @NotNull
    public final String n() {
        String imgPath;
        e eVar = this.cloudGame;
        if (eVar == null || (imgPath = eVar.getImgPath()) == null) {
            return "";
        }
        return imgPath;
    }

    @NotNull
    public final String o(@NotNull Context context) {
        String text;
        Intrinsics.checkNotNullParameter(context, "context");
        e eVar = this.cloudGame;
        if (eVar == null || (text = eVar.getText()) == null) {
            String string = context.getString(R.string.z66);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ame_center_yun_game_tips)");
            return string;
        }
        return text;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final g getGift() {
        return this.gift;
    }

    public final long q() {
        g gVar = this.gift;
        if (gVar != null) {
            return gVar.getCount();
        }
        return 0L;
    }

    @NotNull
    public final String r() {
        String imgPath;
        g gVar = this.gift;
        if (gVar == null || (imgPath = gVar.getImgPath()) == null) {
            return "";
        }
        return imgPath;
    }

    @NotNull
    public final String s(@NotNull Context context) {
        String text;
        Intrinsics.checkNotNullParameter(context, "context");
        g gVar = this.gift;
        if (gVar == null || (text = gVar.getText()) == null) {
            String string = context.getString(R.string.z65);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026game_center_welfare_tips)");
            return string;
        }
        return text;
    }

    @Nullable
    /* renamed from: t, reason: from getter */
    public final h getMessageNotice() {
        return this.messageNotice;
    }

    @NotNull
    public final String u(@NotNull Context context) {
        String msg2;
        Intrinsics.checkNotNullParameter(context, "context");
        h hVar = this.messageNotice;
        if (hVar == null || (msg2 = hVar.getMsg()) == null) {
            String string = context.getString(R.string.f170424z64);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_game_center_notice_tips)");
            return string;
        }
        return msg2;
    }

    public final int v() {
        b bVar = this.batterPassProgress;
        if (bVar != null) {
            return bVar.getCurLevel();
        }
        return 0;
    }

    public final boolean w() {
        b bVar = this.batterPassProgress;
        if (bVar != null) {
            return bVar.getIsAdvancedType();
        }
        return false;
    }

    @NotNull
    public final String x() {
        String imgPath;
        b bVar = this.batterPassProgress;
        if (bVar == null || (imgPath = bVar.getImgPath()) == null) {
            return "";
        }
        return imgPath;
    }

    public final int y() {
        b bVar = this.batterPassProgress;
        if (bVar != null) {
            return bVar.getProgress();
        }
        return 0;
    }

    @Nullable
    /* renamed from: z, reason: from getter */
    public final i getPromotionAd() {
        return this.promotionAd;
    }
}
