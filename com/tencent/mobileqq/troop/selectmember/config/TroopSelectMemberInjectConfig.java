package com.tencent.mobileqq.troop.selectmember.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b!\u0018\u0000 +2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R*\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u0017R*\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0013\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "", "d", "[Ljava/lang/String;", "e", "()[Ljava/lang/String;", "setPartInjectClassNames", "([Ljava/lang/String;)V", "partInjectClassNames", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "titleBarInjectClassName", "g", "setTitleBarRightClickInjectClassName", "titleBarRightClickInjectClassName", h.F, "a", "j", "dataHandlerInjectClassName", "i", "c", "k", "itemDelegateInjectClassNames", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "setItemClickHandlerInjectClassName", "itemClickHandlerInjectClassName", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberInjectConfig implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] partInjectClassNames;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String titleBarInjectClassName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String titleBarRightClickInjectClassName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String dataHandlerInjectClassName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] itemDelegateInjectClassNames;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String itemClickHandlerInjectClassName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberInjectConfig;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberInjectConfig$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion implements Parcelable.Creator<TroopSelectMemberInjectConfig> {
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
        public TroopSelectMemberInjectConfig createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopSelectMemberInjectConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopSelectMemberInjectConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopSelectMemberInjectConfig[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopSelectMemberInjectConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new TroopSelectMemberInjectConfig[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24859);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberInjectConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.partInjectClassNames = new String[0];
            this.itemDelegateInjectClassNames = new String[0];
        }
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.dataHandlerInjectClassName;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.itemClickHandlerInjectClassName;
    }

    @NotNull
    public final String[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.itemDelegateInjectClassNames;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    @NotNull
    public final String[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.partInjectClassNames;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleBarInjectClassName;
    }

    @Nullable
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.titleBarRightClickInjectClassName;
    }

    public final void j(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.dataHandlerInjectClassName = str;
        }
    }

    public final void k(@NotNull String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) strArr);
        } else {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.itemDelegateInjectClassNames = strArr;
        }
    }

    public final void l(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.titleBarInjectClassName = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        String arrays = Arrays.toString(this.partInjectClassNames);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String str = this.titleBarInjectClassName;
        String str2 = this.titleBarRightClickInjectClassName;
        String str3 = this.dataHandlerInjectClassName;
        String arrays2 = Arrays.toString(this.itemDelegateInjectClassNames);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        return "InjectConfig(partInjectClassNames=" + arrays + ", titleBarInjectClassName=" + str + ", titleBarRightClickInjectClassName=" + str2 + ", dataHandlerInjectClassName=" + str3 + ", itemDelegateInjectClassNames=" + arrays2 + ", itemClickHandlerInjectClassName=" + this.itemClickHandlerInjectClassName + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeStringArray(this.partInjectClassNames);
        parcel.writeString(this.titleBarInjectClassName);
        parcel.writeString(this.titleBarRightClickInjectClassName);
        parcel.writeString(this.dataHandlerInjectClassName);
        parcel.writeStringArray(this.itemDelegateInjectClassNames);
        parcel.writeString(this.itemClickHandlerInjectClassName);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopSelectMemberInjectConfig(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
            return;
        }
        String[] createStringArray = parcel.createStringArray();
        this.partInjectClassNames = createStringArray == null ? new String[0] : createStringArray;
        this.titleBarInjectClassName = parcel.readString();
        this.titleBarRightClickInjectClassName = parcel.readString();
        this.dataHandlerInjectClassName = parcel.readString();
        String[] createStringArray2 = parcel.createStringArray();
        this.itemDelegateInjectClassNames = createStringArray2 == null ? new String[0] : createStringArray2;
        this.itemClickHandlerInjectClassName = parcel.readString();
    }
}
