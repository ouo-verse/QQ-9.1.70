package com.tencent.mobileqq.springhb.debug;

import android.os.Parcel;
import android.os.Parcelable;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0003\u0017#$B\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u0010\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0002R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "infoStr", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "i", "", "cnt", "b", "d", "g", "f", "e", "c", "p", "o", "l", h.F, "k", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "getApp", "()Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo;", "Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo;", CacheTable.TABLE_NAME, "J", "lastLogTime", "<init>", "(Lmqq/app/AppRuntime;)V", "DebugMonitorEvent", "DebugMonitorInfo", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class DebugMonitorHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AppRuntime app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private DebugMonitorInfo reportInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastLogTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "info", "", "(Ljava/lang/String;)V", "getInfo", "()Ljava/lang/String;", "springhb-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class DebugMonitorEvent extends SimpleBaseEvent {
        static IPatchRedirector $redirector_;

        @NotNull
        private final String info;

        public DebugMonitorEvent(@NotNull String info) {
            Intrinsics.checkNotNullParameter(info, "info");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) info);
            } else {
                this.info = info;
            }
        }

        @NotNull
        public final String getInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.info;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b%\b\u0086\b\u0018\u0000 42\u00020\u0001:\u0001\u0013BW\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010\u0012\b\b\u0002\u0010%\u001a\u00020\u0010\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\b\b\u0002\u0010,\u001a\u00020\u0010\u0012\b\b\u0002\u00100\u001a\u00020\u0010\u00a2\u0006\u0004\b1\u00102B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\"\u0010\"\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b$\u0010\u0016R\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\"\u0010,\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\"\u00100\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "j", "(J)V", "reportCnt", "e", "c", "l", "reportFilterCnt", "f", "g", "o", "reportToSvrTimes", h.F, DomainData.DOMAIN_NAME, "reportToSvrCnt", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportSucCnt", "b", "k", "reportFailedCnt", BdhLogUtil.LogTag.Tag_Conn, "getSaveFileNumber", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "saveFileNumber", "D", "getSaveFileCnt", "p", "saveFileCnt", "<init>", "(JJJJJJJJ)V", "(Landroid/os/Parcel;)V", "CREATOR", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class DebugMonitorInfo implements Parcelable {
        static IPatchRedirector $redirector_;

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: C, reason: from kotlin metadata */
        private long saveFileNumber;

        /* renamed from: D, reason: from kotlin metadata */
        private long saveFileCnt;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long reportCnt;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long reportFilterCnt;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private long reportToSvrTimes;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long reportToSvrCnt;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long reportSucCnt;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private long reportFailedCnt;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$DebugMonitorInfo;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.springhb.debug.DebugMonitorHelper$DebugMonitorInfo$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion implements Parcelable.Creator<DebugMonitorInfo> {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DebugMonitorInfo createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (DebugMonitorInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new DebugMonitorInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public DebugMonitorInfo[] newArray(int size) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (DebugMonitorInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
                }
                return new DebugMonitorInfo[size];
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.ERROR_EMPTY_DATA);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 35)) {
                redirector.redirect((short) 35);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public DebugMonitorInfo() {
            this(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 34)) {
                return;
            }
            iPatchRedirector.redirect((short) 34, (Object) this);
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.reportCnt;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
            }
            return this.reportFailedCnt;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.reportFilterCnt;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
            }
            return 0;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
            }
            return this.reportSucCnt;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof DebugMonitorInfo)) {
                return false;
            }
            DebugMonitorInfo debugMonitorInfo = (DebugMonitorInfo) other;
            if (this.reportCnt == debugMonitorInfo.reportCnt && this.reportFilterCnt == debugMonitorInfo.reportFilterCnt && this.reportToSvrTimes == debugMonitorInfo.reportToSvrTimes && this.reportToSvrCnt == debugMonitorInfo.reportToSvrCnt && this.reportSucCnt == debugMonitorInfo.reportSucCnt && this.reportFailedCnt == debugMonitorInfo.reportFailedCnt && this.saveFileNumber == debugMonitorInfo.saveFileNumber && this.saveFileCnt == debugMonitorInfo.saveFileCnt) {
                return true;
            }
            return false;
        }

        public final long f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
            }
            return this.reportToSvrCnt;
        }

        public final long g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
            }
            return this.reportToSvrTimes;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
            }
            return (((((((((((((androidx.fragment.app.a.a(this.reportCnt) * 31) + androidx.fragment.app.a.a(this.reportFilterCnt)) * 31) + androidx.fragment.app.a.a(this.reportToSvrTimes)) * 31) + androidx.fragment.app.a.a(this.reportToSvrCnt)) * 31) + androidx.fragment.app.a.a(this.reportSucCnt)) * 31) + androidx.fragment.app.a.a(this.reportFailedCnt)) * 31) + androidx.fragment.app.a.a(this.saveFileNumber)) * 31) + androidx.fragment.app.a.a(this.saveFileCnt);
        }

        public final void j(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, j3);
            } else {
                this.reportCnt = j3;
            }
        }

        public final void k(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, j3);
            } else {
                this.reportFailedCnt = j3;
            }
        }

        public final void l(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            } else {
                this.reportFilterCnt = j3;
            }
        }

        public final void m(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, j3);
            } else {
                this.reportSucCnt = j3;
            }
        }

        public final void n(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, j3);
            } else {
                this.reportToSvrCnt = j3;
            }
        }

        public final void o(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, j3);
            } else {
                this.reportToSvrTimes = j3;
            }
        }

        public final void p(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, j3);
            } else {
                this.saveFileCnt = j3;
            }
        }

        public final void q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, j3);
            } else {
                this.saveFileNumber = j3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (String) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            return "reportCnt:" + this.reportCnt + "\r\nreportFilterCnt:" + this.reportFilterCnt + "\r\nreportToSvrTimes:" + this.reportToSvrTimes + "\r\nreportToSvrCnt:" + this.reportToSvrCnt + "\r\nreportSucCnt:" + this.reportSucCnt + "\r\nreportFailedCnt:" + this.reportFailedCnt + "\r\nsaveFileNumber:" + this.saveFileNumber + "\r\nsaveFileCnt:" + this.saveFileCnt + "\r\n";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) parcel, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.reportCnt);
            parcel.writeLong(this.reportFilterCnt);
            parcel.writeLong(this.reportToSvrTimes);
            parcel.writeLong(this.reportToSvrCnt);
            parcel.writeLong(this.reportSucCnt);
            parcel.writeLong(this.reportFailedCnt);
            parcel.writeLong(this.saveFileNumber);
            parcel.writeLong(this.saveFileCnt);
        }

        public DebugMonitorInfo(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28));
                return;
            }
            this.reportCnt = j3;
            this.reportFilterCnt = j16;
            this.reportToSvrTimes = j17;
            this.reportToSvrCnt = j18;
            this.reportSucCnt = j19;
            this.reportFailedCnt = j26;
            this.saveFileNumber = j27;
            this.saveFileCnt = j28;
        }

        public /* synthetic */ DebugMonitorInfo(long j3, long j16, long j17, long j18, long j19, long j26, long j27, long j28, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0L : j18, (i3 & 16) != 0 ? 0L : j19, (i3 & 32) != 0 ? 0L : j26, (i3 & 64) != 0 ? 0L : j27, (i3 & 128) != 0 ? 0L : j28);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), Long.valueOf(j28), Integer.valueOf(i3), defaultConstructorMarker);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public DebugMonitorInfo(@NotNull Parcel parcel) {
            this(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readLong());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                return;
            }
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) parcel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/springhb/debug/DebugMonitorHelper$a;", "", "", "MONITOR_REPORT_INFO", "Ljava/lang/String;", "TAG", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.debug.DebugMonitorHelper$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.ERROR_TOO_LARGE_DATA);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DebugMonitorHelper() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            return;
        }
        iPatchRedirector.redirect((short) 15, (Object) this);
    }

    private final void i(String infoStr, boolean force) {
        if (force || NetConnInfoCenter.getServerTime() - this.lastLogTime > 60) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringHbReportManager", false, "[DebugMonitorInfo] " + infoStr);
            this.lastLogTime = NetConnInfoCenter.getServerTime();
        }
    }

    static /* synthetic */ void j(DebugMonitorHelper debugMonitorHelper, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        debugMonitorHelper.i(str, z16);
    }

    private final void m() {
        final String h16 = h();
        j(this, h16, false, 2, null);
        if (!b.f289046a.i()) {
            com.tencent.mobileqq.springhb.util.a.f289630a.o("monitor_report_info", this.reportInfo, "2024_spring_hb_debug_", false, this.app);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.debug.a
                @Override // java.lang.Runnable
                public final void run() {
                    DebugMonitorHelper.n(h16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String infoStr) {
        Intrinsics.checkNotNullParameter(infoStr, "$infoStr");
        SimpleEventBus.getInstance().dispatchEvent(new DebugMonitorEvent(infoStr));
    }

    public final void b(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.j(debugMonitorInfo.a() + cnt);
        m();
    }

    public final void c(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.k(debugMonitorInfo.b() + cnt);
        m();
    }

    public final void d(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.l(debugMonitorInfo.c() + cnt);
        m();
    }

    public final void e(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.m(debugMonitorInfo.e() + cnt);
        m();
    }

    public final void f(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.n(debugMonitorInfo.f() + cnt);
        m();
    }

    public final void g(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, cnt);
            return;
        }
        DebugMonitorInfo debugMonitorInfo = this.reportInfo;
        debugMonitorInfo.o(debugMonitorInfo.g() + cnt);
        m();
    }

    @NotNull
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.reportInfo.toString();
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            i(h(), true);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.reportInfo = new DebugMonitorInfo(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
            m();
        }
    }

    public final void o(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, cnt);
        } else {
            this.reportInfo.p(cnt);
            m();
        }
    }

    public final void p(long cnt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, cnt);
        } else {
            this.reportInfo.q(cnt);
            m();
        }
    }

    public DebugMonitorHelper(@Nullable AppRuntime appRuntime) {
        DebugMonitorInfo debugMonitorInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime);
            return;
        }
        this.app = appRuntime;
        if (!b.f289046a.i()) {
            debugMonitorInfo = (DebugMonitorInfo) com.tencent.mobileqq.springhb.util.a.f289630a.g("monitor_report_info", DebugMonitorInfo.class, new DebugMonitorInfo(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null), "2024_spring_hb_debug_", false, appRuntime);
        } else {
            debugMonitorInfo = new DebugMonitorInfo(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 255, null);
        }
        this.reportInfo = debugMonitorInfo;
        i(h(), true);
    }

    public /* synthetic */ DebugMonitorHelper(AppRuntime appRuntime, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : appRuntime);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, appRuntime, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
