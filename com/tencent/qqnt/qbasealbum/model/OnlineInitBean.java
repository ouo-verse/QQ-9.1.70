package com.tencent.qqnt.qbasealbum.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.online.repository.BaseOnlineMediaRepository;
import com.tencent.qqnt.qbasealbum.preview.customize.BaseCustomizePreview;
import com.tencent.qqnt.qbasealbum.preview.view.VideoPreviewBaseView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\fBG\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u000f\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u000f\u00a2\u0006\u0004\b\u001e\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001f\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "Lcom/tencent/qqnt/qbasealbum/model/InitBean;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Z", "a", "()Z", "needShowOnlineAssetTab", "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "e", "Ljava/lang/Class;", "c", "()Ljava/lang/Class;", "onlineMediaViewModel", "Lcom/tencent/qqnt/qbasealbum/online/repository/BaseOnlineMediaRepository;", "f", "b", "onlineMediaRepository", "Lcom/tencent/qqnt/qbasealbum/preview/view/VideoPreviewBaseView;", h.F, "getPreviewView", "previewView", "<init>", "(ZLjava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "(Landroid/os/Parcel;)V", "CREATOR", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class OnlineInitBean implements InitBean {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean needShowOnlineAssetTab;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends com.tencent.qqnt.qbasealbum.online.viewmodel.a> onlineMediaViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends BaseOnlineMediaRepository> onlineMediaRepository;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends VideoPreviewBaseView> previewView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/qbasealbum/model/OnlineInitBean;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.model.OnlineInitBean$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion implements Parcelable.Creator<OnlineInitBean> {
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
        public OnlineInitBean createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (OnlineInitBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OnlineInitBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OnlineInitBean[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (OnlineInitBean[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new OnlineInitBean[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41717);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public OnlineInitBean() {
        this(false, null, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.needShowOnlineAssetTab;
    }

    @NotNull
    public final Class<? extends BaseOnlineMediaRepository> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.onlineMediaRepository;
    }

    @NotNull
    public final Class<? extends com.tencent.qqnt.qbasealbum.online.viewmodel.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.onlineMediaViewModel;
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
        parcel.writeByte(this.needShowOnlineAssetTab ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.onlineMediaViewModel);
        parcel.writeSerializable(this.onlineMediaRepository);
        parcel.writeSerializable(this.previewView);
    }

    public OnlineInitBean(boolean z16, @NotNull Class<? extends com.tencent.qqnt.qbasealbum.online.viewmodel.a> onlineMediaViewModel, @NotNull Class<? extends BaseOnlineMediaRepository> onlineMediaRepository, @NotNull Class<? extends VideoPreviewBaseView> previewView) {
        Intrinsics.checkNotNullParameter(onlineMediaViewModel, "onlineMediaViewModel");
        Intrinsics.checkNotNullParameter(onlineMediaRepository, "onlineMediaRepository");
        Intrinsics.checkNotNullParameter(previewView, "previewView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), onlineMediaViewModel, onlineMediaRepository, previewView);
            return;
        }
        this.needShowOnlineAssetTab = z16;
        this.onlineMediaViewModel = onlineMediaViewModel;
        this.onlineMediaRepository = onlineMediaRepository;
        this.previewView = previewView;
    }

    public /* synthetic */ OnlineInitBean(boolean z16, Class cls, Class cls2, Class cls3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? com.tencent.qqnt.qbasealbum.online.viewmodel.a.class : cls, (i3 & 4) != 0 ? BaseOnlineMediaRepository.class : cls2, (i3 & 8) != 0 ? BaseCustomizePreview.class : cls3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), cls, cls2, cls3, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OnlineInitBean(@NotNull Parcel parcel) {
        this(r0, (Class) r1, (Class) r2, (Class) r3);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        boolean z16 = parcel.readByte() != 0;
        Serializable readSerializable = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable, "null cannot be cast to non-null type java.lang.Class<out com.tencent.qqnt.qbasealbum.online.viewmodel.BaseOnlineMediaViewModel>");
        Serializable readSerializable2 = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable2, "null cannot be cast to non-null type java.lang.Class<out com.tencent.qqnt.qbasealbum.online.repository.BaseOnlineMediaRepository>");
        Serializable readSerializable3 = parcel.readSerializable();
        Intrinsics.checkNotNull(readSerializable3, "null cannot be cast to non-null type java.lang.Class<out com.tencent.qqnt.qbasealbum.preview.view.VideoPreviewBaseView>");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel);
    }
}
