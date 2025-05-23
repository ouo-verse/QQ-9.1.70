package com.tencent.mobileqq.qqlive.sail.model.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import gr4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001\u0013B7\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u00c6\u0001J\t\u0010\u0014\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u000f\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b!\u0010 R\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001d\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "Landroid/os/Parcelable;", "", "j", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "roomId", "", "programId", "enterRoomSystemNotice", "", "Lgr4/k;", "labelInfo", "a", "toString", "hashCode", "", "other", "equals", "d", "J", "g", "()J", "e", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "c", h.F, "Ljava/util/List;", "()Ljava/util/List;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "CREATOR", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class BasicInfo implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final String programId;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final String enterRoomSystemNotice;

    /* renamed from: h */
    @Nullable
    private final List<k> labelInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/sail/model/common/BasicInfo;", "c", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.common.BasicInfo$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion implements Parcelable.Creator<BasicInfo> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a */
        public BasicInfo createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (BasicInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b */
        public BasicInfo[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (BasicInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new BasicInfo[size];
        }

        @NotNull
        public final BasicInfo c(@NotNull Parcel parcel) {
            String str;
            String str2;
            ArrayList arrayList;
            IntRange until;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (BasicInfo) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            if (readString == null) {
                str = "";
            } else {
                str = readString;
            }
            String readString2 = parcel.readString();
            if (readString2 == null) {
                str2 = "";
            } else {
                str2 = readString2;
            }
            int readInt = parcel.readInt();
            if (readInt > 0) {
                ArrayList arrayList2 = new ArrayList();
                until = RangesKt___RangesKt.until(0, readInt);
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    byte[] bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    k label = k.d(bArr);
                    Intrinsics.checkNotNullExpressionValue(label, "label");
                    arrayList2.add(label);
                }
                arrayList = arrayList2;
            } else {
                arrayList = null;
            }
            return new BasicInfo(readLong, str, str2, arrayList);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30856);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BasicInfo() {
        this(0L, null, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this);
    }

    public static /* synthetic */ BasicInfo b(BasicInfo basicInfo, long j3, String str, String str2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = basicInfo.roomId;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            str = basicInfo.programId;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = basicInfo.enterRoomSystemNotice;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            list = basicInfo.labelInfo;
        }
        return basicInfo.a(j16, str3, str4, list);
    }

    @NotNull
    public final BasicInfo a(long roomId, @NotNull String programId, @NotNull String enterRoomSystemNotice, @Nullable List<k> labelInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (BasicInfo) iPatchRedirector.redirect((short) 14, this, Long.valueOf(roomId), programId, enterRoomSystemNotice, labelInfo);
        }
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(enterRoomSystemNotice, "enterRoomSystemNotice");
        return new BasicInfo(roomId, programId, enterRoomSystemNotice, labelInfo);
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.enterRoomSystemNotice;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final List<k> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.labelInfo;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof BasicInfo)) {
            return false;
        }
        BasicInfo basicInfo = (BasicInfo) other;
        if (this.roomId == basicInfo.roomId && Intrinsics.areEqual(this.programId, basicInfo.programId) && Intrinsics.areEqual(this.enterRoomSystemNotice, basicInfo.enterRoomSystemNotice) && Intrinsics.areEqual(this.labelInfo, basicInfo.labelInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.programId;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        int a16 = ((((a.a(this.roomId) * 31) + this.programId.hashCode()) * 31) + this.enterRoomSystemNotice.hashCode()) * 31;
        List<k> list = this.labelInfo;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return a16 + hashCode;
    }

    public final boolean j() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.roomId > 0) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.programId);
            if (!isBlank) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "BasicInfo(roomId=" + this.roomId + ", programId=" + this.programId + ", enterRoomSystemNotice=" + this.enterRoomSystemNotice + ", labelInfo=" + this.labelInfo + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, r56);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.roomId);
        parcel.writeString(this.programId);
        parcel.writeString(this.enterRoomSystemNotice);
        List<k> list = this.labelInfo;
        if (list != null && !list.isEmpty()) {
            parcel.writeInt(this.labelInfo.size());
            for (k kVar : this.labelInfo) {
                int serializedSize = kVar.getSerializedSize();
                parcel.writeInt(serializedSize);
                byte[] bArr = new byte[serializedSize];
                kVar.writeTo(CodedOutputByteBufferNano.newInstance(bArr));
                parcel.writeByteArray(bArr);
            }
            return;
        }
        parcel.writeInt(-1);
    }

    public BasicInfo(long j3, @NotNull String programId, @NotNull String enterRoomSystemNotice, @Nullable List<k> list) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        Intrinsics.checkNotNullParameter(enterRoomSystemNotice, "enterRoomSystemNotice");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), programId, enterRoomSystemNotice, list);
            return;
        }
        this.roomId = j3;
        this.programId = programId;
        this.enterRoomSystemNotice = enterRoomSystemNotice;
        this.labelInfo = list;
    }

    public /* synthetic */ BasicInfo(long j3, String str, String str2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? null : list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, list, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
