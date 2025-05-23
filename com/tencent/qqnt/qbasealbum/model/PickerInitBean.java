package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0016\u0018\u0000 !2\u00020\u0001:\u0002\f\u0016B1\b\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001a\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "nextStepText", "", "e", "Z", "c", "()Z", "showVideoTemplateButton", "f", "b", "selectionPanelHintText", h.F, "getShowTopRecommendTemplatePart", "showTopRecommendTemplatePart", "i", "getShowPickerTips", "showPickerTips", "<init>", "(Ljava/lang/String;ZLjava/lang/String;ZZ)V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class PickerInitBean implements InitBean {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nextStepText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean showVideoTemplateButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String selectionPanelHintText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean showTopRecommendTemplatePart;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean showPickerTips;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\"\u0010\u001d\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean$a;", "", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "a", "", "Ljava/lang/String;", "getNextStepText", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "nextStepText", "", "Z", "getShowVideoTemplateButton", "()Z", "setShowVideoTemplateButton", "(Z)V", "showVideoTemplateButton", "c", "getSelectionPanelHintText", "setSelectionPanelHintText", "selectionPanelHintText", "d", "getShowTopRecommendTemplatePart", "setShowTopRecommendTemplatePart", "showTopRecommendTemplatePart", "e", "getShowPickerTips", "setShowPickerTips", "showPickerTips", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String nextStepText;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean showVideoTemplateButton;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String selectionPanelHintText;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean showTopRecommendTemplatePart;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean showPickerTips;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.nextStepText = "\u53d1\u9001";
                this.selectionPanelHintText = "\u53ef\u540c\u65f6\u9009\u53d6\u56fe\u7247\u4e0e\u89c6\u9891\uff0c\u4e0d\u9650\u7247\u6bb5\u6570";
            }
        }

        @NotNull
        public final PickerInitBean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (PickerInitBean) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return new PickerInitBean(this.nextStepText, this.showVideoTemplateButton, this.selectionPanelHintText, this.showTopRecommendTemplatePart, this.showPickerTips, null);
        }

        public final void b(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.nextStepText = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean$b;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/PickerInitBean;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.PickerInitBean$b, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<PickerInitBean> {
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
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PickerInitBean createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PickerInitBean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PickerInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PickerInitBean[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (PickerInitBean[]) iPatchRedirector.redirect((short) 4, (Object) this, size);
            }
            return new PickerInitBean[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41750);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ PickerInitBean(String str, boolean z16, String str2, boolean z17, boolean z18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, str2, z17, z18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), str2, Boolean.valueOf(z17), Boolean.valueOf(z18), defaultConstructorMarker);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nextStepText;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.selectionPanelHintText;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.showVideoTemplateButton;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.nextStepText);
        parcel.writeByte(this.showVideoTemplateButton ? (byte) 1 : (byte) 0);
        parcel.writeString(this.selectionPanelHintText);
        parcel.writeByte(this.showTopRecommendTemplatePart ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showPickerTips ? (byte) 1 : (byte) 0);
    }

    PickerInitBean(String str, boolean z16, String str2, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16), str2, Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        this.nextStepText = str;
        this.showVideoTemplateButton = z16;
        this.selectionPanelHintText = str2;
        this.showTopRecommendTemplatePart = z17;
        this.showPickerTips = z18;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PickerInitBean(@NotNull Parcel parcel) {
        this(r2, r0, r4, parcel.readByte() != 0, parcel.readByte() != 0);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        boolean z16 = parcel.readByte() != 0;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel);
    }
}
