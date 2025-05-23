package com.tencent.mobileqq.selectfriend.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 22\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b/\u00100B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R2\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00040\"j\b\u0012\u0004\u0012\u00020\u0004`#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\t0\"j\b\u0012\u0004\u0012\u00020\t`#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010%\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setTitleText", "(Ljava/lang/String;)V", "titleText", "I", "c", "()I", "setSelectMode", "(I)V", "selectMode", "", "f", "Z", "isShowSearchBar", "()Z", "setShowSearchBar", "(Z)V", h.F, "getThemeType", "setThemeType", "themeType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "setRecentUserFilterTypeList", "(Ljava/util/ArrayList;)V", "recentUserFilterTypeList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "setRecentUserFilterUinList", "recentUserFilterUinList", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FSLayoutData implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String titleText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int selectMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isShowSearchBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int themeType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Integer> recentUserFilterTypeList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> recentUserFilterUinList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.model.FSLayoutData$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<FSLayoutData> {
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
        public FSLayoutData createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FSLayoutData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FSLayoutData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FSLayoutData[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (FSLayoutData[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new FSLayoutData[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22924);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FSLayoutData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.titleText = "";
        this.isShowSearchBar = true;
        this.themeType = -1;
        this.recentUserFilterTypeList = new ArrayList<>();
        this.recentUserFilterUinList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<Integer> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.recentUserFilterTypeList;
    }

    @NotNull
    public final ArrayList<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (ArrayList) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.recentUserFilterUinList;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.selectMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.titleText;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.titleText);
        parcel.writeInt(this.selectMode);
        parcel.writeByte(this.isShowSearchBar ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.themeType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FSLayoutData(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
            return;
        }
        this.titleText = parcel.readString();
        this.selectMode = parcel.readInt();
        this.isShowSearchBar = parcel.readByte() != 0;
        this.themeType = parcel.readInt();
    }
}
