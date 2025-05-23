package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003J'\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\b2\b\b\u0002\u0010\u0005\u001a\u00020\bH\u00c6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\t\u0010#\u001a\u00020$H\u00d6\u0001J\u0019\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/tencent/mars/smc/IDKey;", "Landroid/os/Parcelable;", "id", "", "key", "value", "(III)V", "()V", "", "(JJJ)V", "getId", "()J", "setId", "(J)V", "getKey", VasCommonJsbProxy.JSON_KEY_SET_KEY, HippyTextInputController.COMMAND_getValue, HippyTextInputController.COMMAND_setValue, "GetId", "GetKey", "GetValue", "SetID", "", "SetKey", "SetValue", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "wechat-sdk-alternative_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class IDKey implements Parcelable {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final Parcelable.Creator<IDKey> CREATOR;
    private long id;
    private long key;
    private long value;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Creator implements Parcelable.Creator<IDKey> {
        static IPatchRedirector $redirector_;

        public Creator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IDKey createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (IDKey) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IDKey(parcel.readLong(), parcel.readLong(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final IDKey[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new IDKey[i3] : (IDKey[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59374);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new Creator();
        }
    }

    public IDKey(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.id = j3;
        this.key = j16;
        this.value = j17;
    }

    public static /* synthetic */ IDKey copy$default(IDKey iDKey, long j3, long j16, long j17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = iDKey.id;
        }
        long j18 = j3;
        if ((i3 & 2) != 0) {
            j16 = iDKey.key;
        }
        long j19 = j16;
        if ((i3 & 4) != 0) {
            j17 = iDKey.value;
        }
        return iDKey.copy(j18, j19, j17);
    }

    public final int GetId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (int) this.id;
    }

    public final int GetKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return (int) this.key;
    }

    public final int GetValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return (int) this.value;
    }

    public final void SetID(int id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, id5);
        } else {
            this.id = id5;
        }
    }

    public final void SetKey(int key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, key);
        } else {
            this.key = key;
        }
    }

    public final void SetValue(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, value);
        } else {
            this.value = value;
        }
    }

    public final long component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.id;
    }

    public final long component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Long) iPatchRedirector.redirect((short) 18, (Object) this)).longValue();
        }
        return this.key;
    }

    public final long component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.value;
    }

    @NotNull
    public final IDKey copy(long id5, long key, long value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (IDKey) iPatchRedirector.redirect((short) 20, this, Long.valueOf(id5), Long.valueOf(key), Long.valueOf(value));
        }
        return new IDKey(id5, key, value);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) other;
        if (this.id == iDKey.id && this.key == iDKey.key && this.value == iDKey.value) {
            return true;
        }
        return false;
    }

    public final long getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.id;
    }

    public final long getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return this.key;
    }

    public final long getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.value;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (((a.a(this.id) * 31) + a.a(this.key)) * 31) + a.a(this.value);
    }

    public final void setId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.id = j3;
        }
    }

    public final void setKey(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.key = j3;
        }
    }

    public final void setValue(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            this.value = j3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return "IDKey(id=" + this.id + ", key=" + this.key + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.id);
        parcel.writeLong(this.key);
        parcel.writeLong(this.value);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IDKey(int i3, int i16, int i17) {
        this(i3, r5, r5);
        long j3 = i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }

    public IDKey() {
        this(0, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
