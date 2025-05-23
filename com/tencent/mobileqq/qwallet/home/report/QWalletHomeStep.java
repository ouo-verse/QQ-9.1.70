package com.tencent.mobileqq.qwallet.home.report;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.report.ReportField;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qqcircle.report.QFS5507ReportHelper;
import cooperation.qzone.util.PerfTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0010\u0005\u000b\u0012\u0003\t\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001dB\u0011\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0001\u000f\u001e\u001f !\"#$%&'()*+,\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "d", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "a", "()Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "stepEnum", "", "e", "J", "b", "()J", "setStepTime", "(J)V", "stepTime", "<init>", "(Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;)V", "c", "f", "ClickAction", "g", h.F, "i", "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "StepEnum", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$a;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$b;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$c;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$d;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$e;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$f;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$ClickAction;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$g;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$h;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$i;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$j;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$k;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$l;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$m;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$n;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class QWalletHomeStep {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StepEnum stepEnum;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long stepTime;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\t\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003J\t\u0010\u000b\u001a\u00020\u0005H\u00d6\u0001J\u0019\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0016\u001a\u00020\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$ClickAction;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "f", "J", "c", "()J", "timestamp", h.F, "I", "getChannel", "()I", WadlProxyConsts.CHANNEL, "i", "Z", "getToolProcessExist", "()Z", "toolProcessExist", "<init>", "(JIZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final /* data */ class ClickAction extends QWalletHomeStep implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<ClickAction> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = PerfTracer.PARAM_CLICK_TIME)
        private final long timestamp;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "entry_channel")
        private final int channel;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "tool_exist")
        private final boolean toolProcessExist;

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
                int readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                return new ClickAction(readLong, readInt, z16);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ClickAction[] newArray(int i3) {
                return new ClickAction[i3];
            }
        }

        public ClickAction(long j3, int i3, boolean z16) {
            super(StepEnum.ClickAction, null);
            this.timestamp = j3;
            this.channel = i3;
            this.toolProcessExist = z16;
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
            if (this.timestamp == clickAction.timestamp && this.channel == clickAction.channel && this.toolProcessExist == clickAction.toolProcessExist) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((androidx.fragment.app.a.a(this.timestamp) * 31) + this.channel) * 31;
            boolean z16 = this.toolProcessExist;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "ClickAction(timestamp=" + this.timestamp + ", channel=" + this.channel + ", toolProcessExist=" + this.toolProcessExist + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeLong(this.timestamp);
            parcel.writeInt(this.channel);
            parcel.writeInt(this.toolProcessExist ? 1 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "", "(Ljava/lang/String;I)V", "ClickAction", "PageCreated", "PageResume", "HomeReqStart", "AdvReqStart", "ViewCreated", "HomeReqFinish", "AdvReqFinish", "RenderView", "H5PageFinished", "AdvDownloaded", "AdvExposure", "AdvLayout", "AdvExposureValid", "AdvClickAction", "PageExit", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public enum StepEnum {
        ClickAction,
        PageCreated,
        PageResume,
        HomeReqStart,
        AdvReqStart,
        ViewCreated,
        HomeReqFinish,
        AdvReqFinish,
        RenderView,
        H5PageFinished,
        AdvDownloaded,
        AdvExposure,
        AdvLayout,
        AdvExposureValid,
        AdvClickAction,
        PageExit
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$a;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvClickAction extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_click_cost")
        private final long cost;

        public AdvClickAction(long j3) {
            super(StepEnum.AdvClickAction, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AdvClickAction) && this.cost == ((AdvClickAction) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "AdvClickAction(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$b;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvExposure extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_exp_cost")
        private final long cost;

        public AdvExposure(long j3) {
            super(StepEnum.AdvExposure, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AdvExposure) && this.cost == ((AdvExposure) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "AdvExposure(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$c;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, h.F, "getAdvExposureTime", "advExposureTime", "<init>", "(JJ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvExposureValid extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_exp_valid_cost")
        private final long cost;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_exp_stay")
        private final long advExposureTime;

        public AdvExposureValid(long j3, long j16) {
            super(StepEnum.AdvExposureValid, null);
            this.cost = j3;
            this.advExposureTime = j16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdvExposureValid)) {
                return false;
            }
            AdvExposureValid advExposureValid = (AdvExposureValid) other;
            if (this.cost == advExposureValid.cost && this.advExposureTime == advExposureValid.advExposureTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.cost) * 31) + androidx.fragment.app.a.a(this.advExposureTime);
        }

        @NotNull
        public String toString() {
            return "AdvExposureValid(cost=" + this.cost + ", advExposureTime=" + this.advExposureTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$d;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "I", "getScreenHeight", "()I", "screenHeight", h.F, "getAdvHeight", "advHeight", "i", "getAdvTop", "advTop", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isAdvCenterExposure", "()Z", "<init>", "(IIIZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvLayout extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "screen_height")
        private final int screenHeight;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_height")
        private final int advHeight;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_top")
        private final int advTop;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "is_center_exp")
        private final boolean isAdvCenterExposure;

        public AdvLayout(int i3, int i16, int i17, boolean z16) {
            super(StepEnum.AdvLayout, null);
            this.screenHeight = i3;
            this.advHeight = i16;
            this.advTop = i17;
            this.isAdvCenterExposure = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdvLayout)) {
                return false;
            }
            AdvLayout advLayout = (AdvLayout) other;
            if (this.screenHeight == advLayout.screenHeight && this.advHeight == advLayout.advHeight && this.advTop == advLayout.advTop && this.isAdvCenterExposure == advLayout.isAdvCenterExposure) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = ((((this.screenHeight * 31) + this.advHeight) * 31) + this.advTop) * 31;
            boolean z16 = this.isAdvCenterExposure;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "AdvLayout(screenHeight=" + this.screenHeight + ", advHeight=" + this.advHeight + ", advTop=" + this.advTop + ", isAdvCenterExposure=" + this.isAdvCenterExposure + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$e;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, h.F, "getReqCost", "reqCost", "i", "Ljava/lang/String;", "getAdvId", "()Ljava/lang/String;", "advId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getReqResult", "()Z", "reqResult", "<init>", "(JJLjava/lang/String;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvReqFinish extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_req_end")
        private final long cost;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_req_cost")
        private final long reqCost;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_id")
        @NotNull
        private final String advId;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "adv_req_result")
        private final boolean reqResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AdvReqFinish(long j3, long j16, @NotNull String advId, boolean z16) {
            super(StepEnum.AdvReqFinish, null);
            Intrinsics.checkNotNullParameter(advId, "advId");
            this.cost = j3;
            this.reqCost = j16;
            this.advId = advId;
            this.reqResult = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AdvReqFinish)) {
                return false;
            }
            AdvReqFinish advReqFinish = (AdvReqFinish) other;
            if (this.cost == advReqFinish.cost && this.reqCost == advReqFinish.reqCost && Intrinsics.areEqual(this.advId, advReqFinish.advId) && this.reqResult == advReqFinish.reqResult) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((androidx.fragment.app.a.a(this.cost) * 31) + androidx.fragment.app.a.a(this.reqCost)) * 31) + this.advId.hashCode()) * 31;
            boolean z16 = this.reqResult;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "AdvReqFinish(cost=" + this.cost + ", reqCost=" + this.reqCost + ", advId=" + this.advId + ", reqResult=" + this.reqResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$f;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$f, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AdvReqStart extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "start_adv_req")
        private final long cost;

        public AdvReqStart(long j3) {
            super(StepEnum.AdvReqStart, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AdvReqStart) && this.cost == ((AdvReqStart) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "AdvReqStart(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$g;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$g, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class H5LoadFinish extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "h5_cost")
        private final long cost;

        public H5LoadFinish(long j3) {
            super(StepEnum.H5PageFinished, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof H5LoadFinish) && this.cost == ((H5LoadFinish) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "H5LoadFinish(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\b\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$h;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, h.F, "getReqCost", "reqCost", "i", "Z", "getReqResult", "()Z", "reqResult", "<init>", "(JJZ)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$h, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class HomeReqFinish extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "home_req_end")
        private final long cost;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "home_req_cost")
        private final long reqCost;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "home_req_result")
        private final boolean reqResult;

        public HomeReqFinish(long j3, long j16, boolean z16) {
            super(StepEnum.HomeReqFinish, null);
            this.cost = j3;
            this.reqCost = j16;
            this.reqResult = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HomeReqFinish)) {
                return false;
            }
            HomeReqFinish homeReqFinish = (HomeReqFinish) other;
            if (this.cost == homeReqFinish.cost && this.reqCost == homeReqFinish.reqCost && this.reqResult == homeReqFinish.reqResult) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((androidx.fragment.app.a.a(this.cost) * 31) + androidx.fragment.app.a.a(this.reqCost)) * 31;
            boolean z16 = this.reqResult;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "HomeReqFinish(cost=" + this.cost + ", reqCost=" + this.reqCost + ", reqResult=" + this.reqResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$i;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$i, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class HomeReqStart extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "start_home_req")
        private final long cost;

        public HomeReqStart(long j3) {
            super(StepEnum.HomeReqStart, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof HomeReqStart) && this.cost == ((HomeReqStart) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "HomeReqStart(cost=" + this.cost + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$j;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, h.F, "Z", "getX5Init", "()Z", "x5Init", "i", "isAdNative", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isCustomChecker", BdhLogUtil.LogTag.Tag_Conn, "I", "getEnterType", "()I", "enterType", "<init>", "(JZZZI)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$j, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageCreated extends QWalletHomeStep {

        /* renamed from: C, reason: from kotlin metadata and from toString */
        @ReportField(name = QFS5507ReportHelper.JsonKey.ENTER_TYPE)
        private final int enterType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "page_create_cost")
        private final long cost;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "web_view_init")
        private final boolean x5Init;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "is_ad_native")
        private final boolean isAdNative;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "is_custom_checker")
        private final boolean isCustomChecker;

        public PageCreated(long j3, boolean z16, boolean z17, boolean z18, int i3) {
            super(StepEnum.PageCreated, null);
            this.cost = j3;
            this.x5Init = z16;
            this.isAdNative = z17;
            this.isCustomChecker = z18;
            this.enterType = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PageCreated)) {
                return false;
            }
            PageCreated pageCreated = (PageCreated) other;
            if (this.cost == pageCreated.cost && this.x5Init == pageCreated.x5Init && this.isAdNative == pageCreated.isAdNative && this.isCustomChecker == pageCreated.isCustomChecker && this.enterType == pageCreated.enterType) {
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
            boolean z17 = this.isAdNative;
            int i18 = z17;
            if (z17 != 0) {
                i18 = 1;
            }
            int i19 = (i17 + i18) * 31;
            boolean z18 = this.isCustomChecker;
            if (!z18) {
                i3 = z18 ? 1 : 0;
            }
            return ((i19 + i3) * 31) + this.enterType;
        }

        @NotNull
        public String toString() {
            return "PageCreated(cost=" + this.cost + ", x5Init=" + this.x5Init + ", isAdNative=" + this.isAdNative + ", isCustomChecker=" + this.isCustomChecker + ", enterType=" + this.enterType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0018\u001a\u00020\n\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$k;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getStayTime", "()J", "stayTime", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", h.F, "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "getLastStep", "()Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;", "lastStep", "i", "getLastStepStayTime", "lastStepStayTime", "<init>", "(JLcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$StepEnum;J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$k, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageQuit extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "total_stay")
        private final long stayTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "last_step")
        @Nullable
        private final StepEnum lastStep;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "last_step_stay")
        private final long lastStepStayTime;

        public PageQuit(long j3, @Nullable StepEnum stepEnum, long j16) {
            super(StepEnum.PageExit, null);
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
            if (this.stayTime == pageQuit.stayTime && this.lastStep == pageQuit.lastStep && this.lastStepStayTime == pageQuit.lastStepStayTime) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int a16 = androidx.fragment.app.a.a(this.stayTime) * 31;
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
            return "PageQuit(stayTime=" + this.stayTime + ", lastStep=" + this.lastStep + ", lastStepStayTime=" + this.lastStepStayTime + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$l;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "I", "c", "()I", "e", "(I)V", "pageVisibleCount", "<init>", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$l, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageResume extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "visible_count")
        private int pageVisibleCount;

        public PageResume() {
            this(0, 1, null);
        }

        /* renamed from: c, reason: from getter */
        public final int getPageVisibleCount() {
            return this.pageVisibleCount;
        }

        public final void e(int i3) {
            this.pageVisibleCount = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PageResume) && this.pageVisibleCount == ((PageResume) other).pageVisibleCount) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.pageVisibleCount;
        }

        @NotNull
        public String toString() {
            return "PageResume(pageVisibleCount=" + this.pageVisibleCount + ")";
        }

        public /* synthetic */ PageResume(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3);
        }

        public PageResume(int i3) {
            super(StepEnum.PageResume, null);
            this.pageVisibleCount = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$m;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$m, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PageViewCreated extends QWalletHomeStep {

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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep$n;", "Lcom/tencent/mobileqq/qwallet/home/report/QWalletHomeStep;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "J", "getCost", "()J", QCircleWeakNetReporter.KEY_COST, "<init>", "(J)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.report.QWalletHomeStep$n, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class RenderView extends QWalletHomeStep {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @ReportField(name = "render_cost")
        private final long cost;

        public RenderView(long j3) {
            super(StepEnum.RenderView, null);
            this.cost = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RenderView) && this.cost == ((RenderView) other).cost) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return androidx.fragment.app.a.a(this.cost);
        }

        @NotNull
        public String toString() {
            return "RenderView(cost=" + this.cost + ")";
        }
    }

    public /* synthetic */ QWalletHomeStep(StepEnum stepEnum, DefaultConstructorMarker defaultConstructorMarker) {
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

    QWalletHomeStep(StepEnum stepEnum) {
        this.stepEnum = stepEnum;
        this.stepTime = System.currentTimeMillis();
    }
}
