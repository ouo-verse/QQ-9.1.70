package com.tencent.mobileqq.qwallet.h5;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.report.ReportField;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.util.PerfTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0012\u0005\u000b\u0013\u0003\t\u0014\u0015\u0016\u0017\u0018B\u0011\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0001\n\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "d", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "a", "()Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "stepEnum", "", "e", "J", "b", "()J", "setStepTime", "(J)V", "stepTime", "<init>", "(Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;)V", "ClickAction", "c", "f", "g", "StepEnum", h.F, "i", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$ClickAction;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$a;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$b;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$c;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$d;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$e;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$f;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$g;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$h;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$i;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class QWalletH5Step {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StepEnum stepEnum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long stepTime;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010 \u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\t\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001aR\u001a\u0010)\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$ClickAction;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "f", "J", "c", "()J", "timestamp", h.F, "Ljava/lang/String;", "getBizTag", "()Ljava/lang/String;", "bizTag", "i", "Z", "getToolProcessExist", "()Z", "toolProcessExist", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getPrivilegedProcessExist", "privilegedProcessExist", BdhLogUtil.LogTag.Tag_Conn, "getOfflineVersion", "offlineVersion", "D", "getUrl", "url", "<init>", "(JLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class ClickAction extends QWalletH5Step implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<ClickAction> CREATOR = new a();

        /* renamed from: C, reason: from kotlin metadata and from toString */
        @ReportField(name = "offline_version")
        @Nullable
        private final String offlineVersion;

        /* renamed from: D, reason: from kotlin metadata and from toString */
        @ReportField(name = "url")
        @NotNull
        private final String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = PerfTracer.PARAM_CLICK_TIME)
        private final long timestamp;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "biz_tag")
        @Nullable
        private final String bizTag;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "tool_exist")
        private final boolean toolProcessExist;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "privileged_exist")
        private final boolean privilegedProcessExist;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes16.dex */
        public static final class a implements Parcelable.Creator<ClickAction> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ClickAction createFromParcel(@NotNull Parcel parcel) {
                boolean z16;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                long readLong = parcel.readLong();
                String readString = parcel.readString();
                boolean z17 = false;
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (parcel.readInt() != 0) {
                    z17 = true;
                }
                return new ClickAction(readLong, readString, z16, z17, parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ClickAction[] newArray(int i3) {
                return new ClickAction[i3];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickAction(long j3, @Nullable String str, boolean z16, boolean z17, @Nullable String str2, @NotNull String url) {
            super(StepEnum.ClickAction, null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.timestamp = j3;
            this.bizTag = str;
            this.toolProcessExist = z16;
            this.privilegedProcessExist = z17;
            this.offlineVersion = str2;
            this.url = url;
        }

        /* renamed from: c, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ClickAction)) {
                return false;
            }
            ClickAction clickAction = (ClickAction) other;
            if (this.timestamp == clickAction.timestamp && Intrinsics.areEqual(this.bizTag, clickAction.bizTag) && this.toolProcessExist == clickAction.toolProcessExist && this.privilegedProcessExist == clickAction.privilegedProcessExist && Intrinsics.areEqual(this.offlineVersion, clickAction.offlineVersion) && Intrinsics.areEqual(this.url, clickAction.url)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int a16 = androidx.fragment.app.a.a(this.timestamp) * 31;
            String str = this.bizTag;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            boolean z16 = this.toolProcessExist;
            int i17 = 1;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (i16 + i18) * 31;
            boolean z17 = this.privilegedProcessExist;
            if (!z17) {
                i17 = z17 ? 1 : 0;
            }
            int i26 = (i19 + i17) * 31;
            String str2 = this.offlineVersion;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return ((i26 + i3) * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "ClickAction(timestamp=" + this.timestamp + ", bizTag=" + this.bizTag + ", toolProcessExist=" + this.toolProcessExist + ", privilegedProcessExist=" + this.privilegedProcessExist + ", offlineVersion=" + this.offlineVersion + ", url=" + this.url + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeLong(this.timestamp);
            parcel.writeString(this.bizTag);
            parcel.writeInt(this.toolProcessExist ? 1 : 0);
            parcel.writeInt(this.privilegedProcessExist ? 1 : 0);
            parcel.writeString(this.offlineVersion);
            parcel.writeString(this.url);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "", "(Ljava/lang/String;I)V", "ClickAction", "PageCreated", "ViewCreated", "X5Init", "LoadUrl", "FirstProgress", "H5PageStarted", "ReceiveTitle", "H5PageFinished", "PageExit", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum StepEnum {
        ClickAction,
        PageCreated,
        ViewCreated,
        X5Init,
        LoadUrl,
        FirstProgress,
        H5PageStarted,
        ReceiveTitle,
        H5PageFinished,
        PageExit
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$a;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class FirstProgress extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "first_progress_cost")
        private final long cost;

        public FirstProgress(long j3) {
            super(StepEnum.FirstProgress, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FirstProgress) && this.cost == ((FirstProgress) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "FirstProgress(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$b;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class H5LoadFinished extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "h5_load_finish_cost")
        private final long cost;

        public H5LoadFinished(long j3) {
            super(StepEnum.H5PageFinished, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof H5LoadFinished) && this.cost == ((H5LoadFinished) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "H5LoadFinished(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$c;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class H5PageStarted extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "h5_page_started_cost")
        private final long cost;

        public H5PageStarted(long j3) {
            super(StepEnum.H5PageStarted, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof H5PageStarted) && this.cost == ((H5PageStarted) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "H5PageStarted(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$d;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, h.F, "Z", "getX5Init", "()Z", "x5Init", "i", "getHasLoginCookies", "hasLoginCookies", "<init>", "(JZZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageCreated extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "page_create_cost")
        private final long cost;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "web_view_init")
        private final boolean x5Init;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "has_login_cookies")
        private final boolean hasLoginCookies;

        public PageCreated(long j3, boolean z16, boolean z17) {
            super(StepEnum.PageCreated, null);
            this.cost = j3;
            this.x5Init = z16;
            this.hasLoginCookies = z17;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageCreated)) {
                return false;
            }
            PageCreated pageCreated = (PageCreated) other;
            if (this.cost == pageCreated.cost && this.x5Init == pageCreated.x5Init && this.hasLoginCookies == pageCreated.hasLoginCookies) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = androidx.fragment.app.a.a(this.cost) * 31;
            boolean z16 = this.x5Init;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (a16 + i16) * 31;
            boolean z17 = this.hasLoginCookies;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "PageCreated(cost=" + this.cost + ", x5Init=" + this.x5Init + ", hasLoginCookies=" + this.hasLoginCookies + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$e;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Z", "getHasInvalidCookie", "()Z", "hasInvalidCookie", "", h.F, "J", "getStayTime", "()J", "stayTime", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "i", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "getLastStep", "()Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;", "lastStep", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getLastStepStayTime", "lastStepStayTime", "<init>", "(ZJLcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$StepEnum;J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageQuit extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "has_invalid_cookie")
        private final boolean hasInvalidCookie;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "total_stay")
        private final long stayTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "last_step")
        @Nullable
        private final StepEnum lastStep;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "last_step_stay")
        private final long lastStepStayTime;

        public PageQuit(boolean z16, long j3, @Nullable StepEnum stepEnum, long j16) {
            super(StepEnum.PageExit, null);
            this.hasInvalidCookie = z16;
            this.stayTime = j3;
            this.lastStep = stepEnum;
            this.lastStepStayTime = j16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageQuit)) {
                return false;
            }
            PageQuit pageQuit = (PageQuit) other;
            if (this.hasInvalidCookie == pageQuit.hasInvalidCookie && this.stayTime == pageQuit.stayTime && this.lastStep == pageQuit.lastStep && this.lastStepStayTime == pageQuit.lastStepStayTime) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.hasInvalidCookie;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int a16 = ((r06 * 31) + androidx.fragment.app.a.a(this.stayTime)) * 31;
            StepEnum stepEnum = this.lastStep;
            if (stepEnum == null) {
                hashCode = 0;
            } else {
                hashCode = stepEnum.hashCode();
            }
            return ((a16 + hashCode) * 31) + androidx.fragment.app.a.a(this.lastStepStayTime);
        }

        @NotNull
        public String toString() {
            return "PageQuit(hasInvalidCookie=" + this.hasInvalidCookie + ", stayTime=" + this.stayTime + ", lastStep=" + this.lastStep + ", lastStepStayTime=" + this.lastStepStayTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$f;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$f, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageViewCreated extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "view_created_cost")
        private final long cost;

        public PageViewCreated(long j3) {
            super(StepEnum.ViewCreated, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PageViewCreated) && this.cost == ((PageViewCreated) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "PageViewCreated(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$g;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$g, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ReceiveTitle extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "receive_title_cost")
        private final long cost;

        public ReceiveTitle(long j3) {
            super(StepEnum.ReceiveTitle, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ReceiveTitle) && this.cost == ((ReceiveTitle) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "ReceiveTitle(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$h;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$h, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class X5Init extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "x5_init_cost")
        private final long cost;

        public X5Init(long j3) {
            super(StepEnum.X5Init, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof X5Init) && this.cost == ((X5Init) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "X5Init(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step$i;", "Lcom/tencent/mobileqq/qwallet/h5/QWalletH5Step;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.h5.QWalletH5Step$i, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class onLoadUrl extends QWalletH5Step {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "on_load_url_cost")
        private final long cost;

        public onLoadUrl(long j3) {
            super(StepEnum.LoadUrl, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof onLoadUrl) && this.cost == ((onLoadUrl) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "onLoadUrl(cost=" + this.cost + ")";
        }
    }

    public /* synthetic */ QWalletH5Step(StepEnum stepEnum, DefaultConstructorMarker defaultConstructorMarker) {
        this(stepEnum);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final StepEnum getStepEnum() {
        return this.stepEnum;
    }

    /* renamed from: b, reason: from getter */
    public final long getStepTime() {
        return this.stepTime;
    }

    QWalletH5Step(StepEnum stepEnum) {
        this.stepEnum = stepEnum;
        this.stepTime = System.currentTimeMillis();
    }
}
