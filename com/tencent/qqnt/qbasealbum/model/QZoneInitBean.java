package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.preview.customize.BaseCustomizePreview;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 B2\u00020\u0001:\u0001CB}\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u000f\u0012\b\b\u0002\u00107\u001a\u000200\u0012\u0010\b\u0002\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020908\u00a2\u0006\u0004\b?\u0010@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\u0018R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010)R\"\u0010/\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010.R\"\u00107\u001a\u0002008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001f\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u000209088\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "d", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "getQZoneMediaTabType", "()Lcom/tencent/qqnt/qbasealbum/model/TabType;", "qZoneMediaTabType", "", "e", "Z", "getShowNextStepButton", "()Z", "showNextStepButton", "f", "I", "getNextStepMinMediaNum", "()I", "nextStepMinMediaNum", h.F, "getNextStepMaxMediaNum", "nextStepMaxMediaNum", "i", "getShowVideoTemplateButton", "showVideoTemplateButton", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getVideoTemplateMinMediaNum", "videoTemplateMinMediaNum", BdhLogUtil.LogTag.Tag_Conn, "getVideoTemplateMaxMediaNum", "videoTemplateMaxMediaNum", "D", "getMaxVideoCountLimitNum", "setMaxVideoCountLimitNum", "(I)V", "maxVideoCountLimitNum", "E", "getShowSelectionPanelThumbNail", "setShowSelectionPanelThumbNail", "(Z)V", "showSelectionPanelThumbNail", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getTopBannerTextContent", "()Ljava/lang/String;", "setTopBannerTextContent", "(Ljava/lang/String;)V", "topBannerTextContent", "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/preview/customize/BaseCustomizePreview;", "G", "Ljava/lang/Class;", "getPreviewView", "()Ljava/lang/Class;", "previewView", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/TabType;ZIIZIIIZLjava/lang/String;Ljava/lang/Class;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class QZoneInitBean implements InitBean {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int videoTemplateMaxMediaNum;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxVideoCountLimitNum;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showSelectionPanelThumbNail;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String topBannerTextContent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Class<? extends BaseCustomizePreview> previewView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TabType qZoneMediaTabType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean showNextStepButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int nextStepMinMediaNum;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int nextStepMaxMediaNum;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean showVideoTemplateButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int videoTemplateMinMediaNum;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/QZoneInitBean;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.QZoneInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<QZoneInitBean> {
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
        public QZoneInitBean createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QZoneInitBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QZoneInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneInitBean[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QZoneInitBean[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new QZoneInitBean[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QZoneInitBean() {
        this(null, false, 0, 0, false, 0, 0, 0, false, null, null, 2047, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.qZoneMediaTabType.name());
        parcel.writeByte(this.showNextStepButton ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.nextStepMinMediaNum);
        parcel.writeInt(this.nextStepMaxMediaNum);
        parcel.writeByte(this.showVideoTemplateButton ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.videoTemplateMinMediaNum);
        parcel.writeInt(this.videoTemplateMaxMediaNum);
        parcel.writeInt(this.maxVideoCountLimitNum);
        parcel.writeByte(this.showSelectionPanelThumbNail ? (byte) 1 : (byte) 0);
        parcel.writeString(this.topBannerTextContent);
        parcel.writeSerializable(this.previewView);
    }

    public QZoneInitBean(@NotNull TabType qZoneMediaTabType, boolean z16, int i3, int i16, boolean z17, int i17, int i18, int i19, boolean z18, @NotNull String topBannerTextContent, @NotNull Class<? extends BaseCustomizePreview> previewView) {
        Intrinsics.checkNotNullParameter(qZoneMediaTabType, "qZoneMediaTabType");
        Intrinsics.checkNotNullParameter(topBannerTextContent, "topBannerTextContent");
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qZoneMediaTabType, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z18), topBannerTextContent, previewView);
            return;
        }
        this.qZoneMediaTabType = qZoneMediaTabType;
        this.showNextStepButton = z16;
        this.nextStepMinMediaNum = i3;
        this.nextStepMaxMediaNum = i16;
        this.showVideoTemplateButton = z17;
        this.videoTemplateMinMediaNum = i17;
        this.videoTemplateMaxMediaNum = i18;
        this.maxVideoCountLimitNum = i19;
        this.showSelectionPanelThumbNail = z18;
        this.topBannerTextContent = topBannerTextContent;
        this.previewView = previewView;
    }

    public /* synthetic */ QZoneInitBean(TabType tabType, boolean z16, int i3, int i16, boolean z17, int i17, int i18, int i19, boolean z18, String str, Class cls, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? TabType.TAB_MEDIA : tabType, (i26 & 2) != 0 ? true : z16, (i26 & 4) != 0 ? 0 : i3, (i26 & 8) != 0 ? 0 : i16, (i26 & 16) != 0 ? true : z17, (i26 & 32) != 0 ? 0 : i17, (i26 & 64) != 0 ? 0 : i18, (i26 & 128) != 0 ? 50 : i19, (i26 & 256) != 0 ? false : z18, (i26 & 512) != 0 ? "" : str, (i26 & 1024) != 0 ? BaseCustomizePreview.class : cls);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, tabType, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z17), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Boolean.valueOf(z18), str, cls, Integer.valueOf(i26), defaultConstructorMarker);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QZoneInitBean(@NotNull Parcel parcel) {
        this(r2, r0, r4, r5, r6, r7, r8, r9, r10, r11, (Class) r1);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        Intrinsics.checkNotNull(readString);
        TabType valueOf = TabType.valueOf(readString);
        boolean z16 = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        boolean z17 = parcel.readByte() != 0;
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        boolean z18 = parcel.readByte() != 0;
        String readString2 = parcel.readString();
        Intrinsics.checkNotNull(readString2);
        Serializable readSerializable = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type java.lang.Class<out com.tencent.qqnt.qbasealbum.preview.customize.BaseCustomizePreview>");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) parcel);
    }
}
