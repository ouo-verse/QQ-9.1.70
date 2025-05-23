package com.tencent.qqnt.aio.msg.element;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "<init>", "()V", "a", "b", "c", "d", "MultiPicElement", "e", "f", "g", tl.h.F, "i", "j", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$a;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$c;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$d;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$e;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$f;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$g;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$i;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class AIOElementType {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b$\b\u0086\b\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0001\u0014B7\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u001f\u001a\u00020\n\u0012\u0006\u0010\"\u001a\u00020\n\u0012\u0006\u0010&\u001a\u00020\u0011\u0012\u0006\u0010*\u001a\u00020\u0011\u0012\u0006\u00100\u001a\u00020\u0005\u00a2\u0006\u0004\b1\u00102B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b1\u00103J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\f\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010&\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\"\u0010*\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\"\u00100\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b\u0019\u0010-\"\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "Landroid/os/Parcelable;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "", "d", "J", "a", "()J", "f", "(J)V", "id", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "path", "c", "j", "thumbPath", tl.h.F, HippyQQPagView.FunctionName.GET_PROGRESS, HippyQQPagView.FunctionName.SET_PROGRESS, "progress", "i", "getTotalProgress", "k", "totalProgress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "()I", "l", "(I)V", "transferStatus", "<init>", "(JLjava/lang/String;Ljava/lang/String;JJI)V", "(Landroid/os/Parcel;)V", "CREATOR", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class MultiPicElement extends AIOElementType implements Parcelable {
        static IPatchRedirector $redirector_;

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private long id;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String path;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String thumbPath;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long progress;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long totalProgress;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private int transferStatus;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/qqnt/aio/msg/element/AIOElementType$MultiPicElement;", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.msg.element.AIOElementType$MultiPicElement$a, reason: from kotlin metadata */
        /* loaded from: classes23.dex */
        public static final class Companion implements Parcelable.Creator<MultiPicElement> {
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
            public MultiPicElement createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (MultiPicElement) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MultiPicElement(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public MultiPicElement[] newArray(int size) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (MultiPicElement[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
                }
                return new MultiPicElement[size];
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51162);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 27)) {
                redirector.redirect((short) 27);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiPicElement(long j3, @NotNull String path, @NotNull String thumbPath, long j16, long j17, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(thumbPath, "thumbPath");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), path, thumbPath, Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3));
                return;
            }
            this.id = j3;
            this.path = path;
            this.thumbPath = thumbPath;
            this.progress = j16;
            this.totalProgress = j17;
            this.transferStatus = i3;
        }

        public final long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.id;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.path;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.thumbPath;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            return 0;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.transferStatus;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiPicElement)) {
                return false;
            }
            MultiPicElement multiPicElement = (MultiPicElement) other;
            if (this.id == multiPicElement.id && Intrinsics.areEqual(this.path, multiPicElement.path) && Intrinsics.areEqual(this.thumbPath, multiPicElement.thumbPath) && this.progress == multiPicElement.progress && this.totalProgress == multiPicElement.totalProgress && this.transferStatus == multiPicElement.transferStatus) {
                return true;
            }
            return false;
        }

        public final void f(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.id = j3;
            }
        }

        public final void g(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.path = str;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
            }
            return (((((((((androidx.fragment.app.a.a(this.id) * 31) + this.path.hashCode()) * 31) + this.thumbPath.hashCode()) * 31) + androidx.fragment.app.a.a(this.progress)) * 31) + androidx.fragment.app.a.a(this.totalProgress)) * 31) + this.transferStatus;
        }

        public final void j(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.thumbPath = str;
            }
        }

        public final void k(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, j3);
            } else {
                this.totalProgress = j3;
            }
        }

        public final void l(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, i3);
            } else {
                this.transferStatus = i3;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return "MultiPicElement(id=" + this.id + ", path=" + this.path + ", thumbPath=" + this.thumbPath + ", progress=" + this.progress + ", totalProgress=" + this.totalProgress + ", transferStatus=" + this.transferStatus + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) parcel, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeLong(this.id);
            parcel.writeString(this.path);
            parcel.writeString(this.thumbPath);
            parcel.writeLong(this.progress);
            parcel.writeLong(this.totalProgress);
            parcel.writeInt(this.transferStatus);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MultiPicElement(@NotNull Parcel parcel) {
            this(r2, r4, r5, parcel.readLong(), parcel.readLong(), parcel.readInt());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            Intrinsics.checkNotNull(readString);
            String readString2 = parcel.readString();
            Intrinsics.checkNotNull(readString2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) parcel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$a;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/FaceBubbleElement;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class a extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FaceBubbleElement item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull FaceBubbleElement item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) item);
            } else {
                this.item = item;
            }
        }

        @NotNull
        public final FaceBubbleElement a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FaceBubbleElement) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.item;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof a) && Intrinsics.areEqual(this.item, ((a) other).item)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.item.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "FaceBubbleAIOElement(item=" + this.item + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b[\b\u0086\b\u0018\u00002\u00020\u0001B\u00ed\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0002\u0012\b\b\u0002\u0010@\u001a\u00020\u0004\u0012\b\b\u0002\u0010D\u001a\u00020\u0004\u0012\b\b\u0002\u0010H\u001a\u00020\u0002\u0012\b\b\u0002\u0010K\u001a\u00020\u0002\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u0012\b\b\u0002\u0010Q\u001a\u00020\u0004\u0012\b\b\u0002\u0010U\u001a\u00020\u0004\u0012\b\b\u0002\u0010X\u001a\u00020\u0002\u0012\b\b\u0002\u0010\\\u001a\u00020\u0004\u0012\b\b\u0002\u0010`\u001a\u00020\u0004\u00a2\u0006\u0004\ba\u0010bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000fR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b \u0010\u0019R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u000b\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017\"\u0004\b2\u0010\u0019R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u000b\u001a\u0004\b5\u0010\r\"\u0004\b4\u0010\u000fR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u000b\u001a\u0004\b8\u0010\r\"\u0004\b0\u0010\u000fR\"\u0010<\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R\"\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\u000b\u001a\u0004\b>\u0010\r\"\u0004\b?\u0010\u000fR\"\u0010D\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0015\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\bI\u0010\u0017\"\u0004\bJ\u0010\u0019R\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u000b\u001a\u0004\bL\u0010\r\"\u0004\b,\u0010\u000fR\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\u000b\u001a\u0004\bO\u0010\r\"\u0004\bP\u0010\u000fR\"\u0010U\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u000b\u001a\u0004\bS\u0010\r\"\u0004\bT\u0010\u000fR\"\u0010X\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u0015\u001a\u0004\bW\u0010\u0017\"\u0004\b%\u0010\u0019R\"\u0010\\\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010\u000b\u001a\u0004\bZ\u0010\r\"\u0004\b[\u0010\u000fR\"\u0010`\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\u000b\u001a\u0004\b^\u0010\r\"\u0004\b_\u0010\u000f\u00a8\u0006c"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$b;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "g", "()I", "B", "(I)V", "faceType", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "faceIndex", "f", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "D", "(Ljava/lang/String;)V", "packId", tl.h.F, "j", "setImageType", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "faceText", "u", "V", "stickerId", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "M", "sourceType", "v", "Z", com.tencent.luggage.wxa.c8.c.f123402w, "E", "r", "setResultId", "resultId", UserInfo.SEX_FEMALE, "getSurpriseId", "setSurpriseId", "surpriseId", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "randomType", "H", "p", "pokeType", "t", "N", "spokeSummary", "J", "b", "setDoubleHit", "doubleHit", "K", "w", "a0", "vaspokeId", "L", "y", "c0", "vaspokeName", HippyTKDListViewAdapter.X, "b0", "vaspokeMinver", "o", "pokeStrength", "P", "k", "setMsgType", QQBrowserActivity.KEY_MSG_TYPE, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", "setFaceBubbleCount", "faceBubbleCount", BdhLogUtil.LogTag.Tag_Req, "l", "oldVersionStr", ExifInterface.LATITUDE_SOUTH, DomainData.DOMAIN_NAME, "setPokeFlag", "pokeFlag", "T", "a", "setChainCount", "chainCount", "<init>", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IILjava/lang/String;IILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;II)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class b extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private int sourceType;

        /* renamed from: D, reason: from kotlin metadata */
        private int stickerType;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private String resultId;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private String surpriseId;

        /* renamed from: G, reason: from kotlin metadata */
        private int randomType;

        /* renamed from: H, reason: from kotlin metadata */
        private int pokeType;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private String spokeSummary;

        /* renamed from: J, reason: from kotlin metadata */
        private int doubleHit;

        /* renamed from: K, reason: from kotlin metadata */
        private int vaspokeId;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private String vaspokeName;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private String vaspokeMinver;

        /* renamed from: N, reason: from kotlin metadata */
        private int pokeStrength;

        /* renamed from: P, reason: from kotlin metadata */
        private int msgType;

        /* renamed from: Q, reason: from kotlin metadata */
        private int faceBubbleCount;

        /* renamed from: R, reason: from kotlin metadata */
        @NotNull
        private String oldVersionStr;

        /* renamed from: S, reason: from kotlin metadata */
        private int pokeFlag;

        /* renamed from: T, reason: from kotlin metadata */
        private int chainCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int faceType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int faceIndex;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String packId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int imageType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String faceText;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String stickerId;

        public b() {
            this(0, 0, null, 0, null, null, 0, 0, null, null, 0, 0, null, 0, 0, null, null, 0, 0, 0, null, 0, 0, 8388607, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 76)) {
                return;
            }
            iPatchRedirector.redirect((short) 76, (Object) this);
        }

        public final void A(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.faceText = str;
            }
        }

        public final void B(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3);
            } else {
                this.faceType = i3;
            }
        }

        public final void C(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
                iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.oldVersionStr = str;
            }
        }

        public final void D(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.packId = str;
            }
        }

        public final void E(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
                iPatchRedirector.redirect((short) 38, (Object) this, i3);
            } else {
                this.pokeStrength = i3;
            }
        }

        public final void F(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                iPatchRedirector.redirect((short) 26, (Object) this, i3);
            } else {
                this.pokeType = i3;
            }
        }

        public final void G(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                iPatchRedirector.redirect((short) 24, (Object) this, i3);
            } else {
                this.randomType = i3;
            }
        }

        public final void M(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, i3);
            } else {
                this.sourceType = i3;
            }
        }

        public final void N(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
                iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.spokeSummary = str;
            }
        }

        public final void V(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.stickerId = str;
            }
        }

        public final void Z(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, i3);
            } else {
                this.stickerType = i3;
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
                return ((Integer) iPatchRedirector.redirect((short) 47, (Object) this)).intValue();
            }
            return this.chainCount;
        }

        public final void a0(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
                iPatchRedirector.redirect((short) 32, (Object) this, i3);
            } else {
                this.vaspokeId = i3;
            }
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
                return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
            }
            return this.doubleHit;
        }

        public final void b0(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
                iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.vaspokeMinver = str;
            }
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
                return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
            }
            return this.faceBubbleCount;
        }

        public final void c0(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
                iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.vaspokeName = str;
            }
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.faceIndex;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
                return ((Boolean) iPatchRedirector.redirect((short) 75, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.faceType == bVar.faceType && this.faceIndex == bVar.faceIndex && Intrinsics.areEqual(this.packId, bVar.packId) && this.imageType == bVar.imageType && Intrinsics.areEqual(this.faceText, bVar.faceText) && Intrinsics.areEqual(this.stickerId, bVar.stickerId) && this.sourceType == bVar.sourceType && this.stickerType == bVar.stickerType && Intrinsics.areEqual(this.resultId, bVar.resultId) && Intrinsics.areEqual(this.surpriseId, bVar.surpriseId) && this.randomType == bVar.randomType && this.pokeType == bVar.pokeType && Intrinsics.areEqual(this.spokeSummary, bVar.spokeSummary) && this.doubleHit == bVar.doubleHit && this.vaspokeId == bVar.vaspokeId && Intrinsics.areEqual(this.vaspokeName, bVar.vaspokeName) && Intrinsics.areEqual(this.vaspokeMinver, bVar.vaspokeMinver) && this.pokeStrength == bVar.pokeStrength && this.msgType == bVar.msgType && this.faceBubbleCount == bVar.faceBubbleCount && Intrinsics.areEqual(this.oldVersionStr, bVar.oldVersionStr) && this.pokeFlag == bVar.pokeFlag && this.chainCount == bVar.chainCount) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return this.faceText;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.faceType;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
                return ((Integer) iPatchRedirector.redirect((short) 74, (Object) this)).intValue();
            }
            return (((((((((((((((((((((((((((((((((((((((((((this.faceType * 31) + this.faceIndex) * 31) + this.packId.hashCode()) * 31) + this.imageType) * 31) + this.faceText.hashCode()) * 31) + this.stickerId.hashCode()) * 31) + this.sourceType) * 31) + this.stickerType) * 31) + this.resultId.hashCode()) * 31) + this.surpriseId.hashCode()) * 31) + this.randomType) * 31) + this.pokeType) * 31) + this.spokeSummary.hashCode()) * 31) + this.doubleHit) * 31) + this.vaspokeId) * 31) + this.vaspokeName.hashCode()) * 31) + this.vaspokeMinver.hashCode()) * 31) + this.pokeStrength) * 31) + this.msgType) * 31) + this.faceBubbleCount) * 31) + this.oldVersionStr.hashCode()) * 31) + this.pokeFlag) * 31) + this.chainCount;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.imageType;
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
                return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
            }
            return this.msgType;
        }

        @NotNull
        public final String l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
                return (String) iPatchRedirector.redirect((short) 43, (Object) this);
            }
            return this.oldVersionStr;
        }

        @NotNull
        public final String m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.packId;
        }

        public final int n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
                return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
            }
            return this.pokeFlag;
        }

        public final int o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
                return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
            }
            return this.pokeStrength;
        }

        public final int p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
            }
            return this.pokeType;
        }

        public final int q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
            }
            return this.randomType;
        }

        @NotNull
        public final String r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return this.resultId;
        }

        public final int s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return this.sourceType;
        }

        @NotNull
        public final String t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return (String) iPatchRedirector.redirect((short) 27, (Object) this);
            }
            return this.spokeSummary;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
                return (String) iPatchRedirector.redirect((short) 73, (Object) this);
            }
            return "FaceElement(faceType=" + this.faceType + ", faceIndex=" + this.faceIndex + ", packId=" + this.packId + ", imageType=" + this.imageType + ", faceText=" + this.faceText + ", stickerId=" + this.stickerId + ", sourceType=" + this.sourceType + ", stickerType=" + this.stickerType + ", resultId=" + this.resultId + ", surpriseId=" + this.surpriseId + ", randomType=" + this.randomType + ", pokeType=" + this.pokeType + ", spokeSummary=" + this.spokeSummary + ", doubleHit=" + this.doubleHit + ", vaspokeId=" + this.vaspokeId + ", vaspokeName=" + this.vaspokeName + ", vaspokeMinver=" + this.vaspokeMinver + ", pokeStrength=" + this.pokeStrength + ", msgType=" + this.msgType + ", faceBubbleCount=" + this.faceBubbleCount + ", oldVersionStr=" + this.oldVersionStr + ", pokeFlag=" + this.pokeFlag + ", chainCount=" + this.chainCount + ")";
        }

        @NotNull
        public final String u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return this.stickerId;
        }

        public final int v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            return this.stickerType;
        }

        public final int w() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
                return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
            }
            return this.vaspokeId;
        }

        @NotNull
        public final String x() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
                return (String) iPatchRedirector.redirect((short) 35, (Object) this);
            }
            return this.vaspokeMinver;
        }

        @NotNull
        public final String y() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
                return (String) iPatchRedirector.redirect((short) 33, (Object) this);
            }
            return this.vaspokeName;
        }

        public final void z(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.faceIndex = i3;
            }
        }

        public /* synthetic */ b(int i3, int i16, String str, int i17, String str2, String str3, int i18, int i19, String str4, String str5, int i26, int i27, String str6, int i28, int i29, String str7, String str8, int i36, int i37, int i38, String str9, int i39, int i46, int i47, DefaultConstructorMarker defaultConstructorMarker) {
            this((i47 & 1) != 0 ? 0 : i3, (i47 & 2) != 0 ? 0 : i16, (i47 & 4) != 0 ? "" : str, (i47 & 8) != 0 ? 0 : i17, (i47 & 16) != 0 ? "" : str2, (i47 & 32) != 0 ? "" : str3, (i47 & 64) != 0 ? 0 : i18, (i47 & 128) != 0 ? 0 : i19, (i47 & 256) != 0 ? "" : str4, (i47 & 512) != 0 ? "" : str5, (i47 & 1024) != 0 ? 0 : i26, (i47 & 2048) != 0 ? 0 : i27, (i47 & 4096) != 0 ? "" : str6, (i47 & 8192) != 0 ? 0 : i28, (i47 & 16384) != 0 ? 0 : i29, (32768 & i47) != 0 ? "" : str7, (65536 & i47) != 0 ? "" : str8, (131072 & i47) != 0 ? 0 : i36, (262144 & i47) != 0 ? 0 : i37, (524288 & i47) != 0 ? 0 : i38, (1048576 & i47) != 0 ? "" : str9, (2097152 & i47) != 0 ? 0 : i39, (4194304 & i47) != 0 ? 0 : i46);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, Integer.valueOf(i17), str2, str3, Integer.valueOf(i18), Integer.valueOf(i19), str4, str5, Integer.valueOf(i26), Integer.valueOf(i27), str6, Integer.valueOf(i28), Integer.valueOf(i29), str7, str8, Integer.valueOf(i36), Integer.valueOf(i37), Integer.valueOf(i38), str9, Integer.valueOf(i39), Integer.valueOf(i46), Integer.valueOf(i47), defaultConstructorMarker);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i3, int i16, @NotNull String packId, int i17, @NotNull String faceText, @NotNull String stickerId, int i18, int i19, @NotNull String resultId, @NotNull String surpriseId, int i26, int i27, @NotNull String spokeSummary, int i28, int i29, @NotNull String vaspokeName, @NotNull String vaspokeMinver, int i36, int i37, int i38, @NotNull String oldVersionStr, int i39, int i46) {
            super(null);
            Intrinsics.checkNotNullParameter(packId, "packId");
            Intrinsics.checkNotNullParameter(faceText, "faceText");
            Intrinsics.checkNotNullParameter(stickerId, "stickerId");
            Intrinsics.checkNotNullParameter(resultId, "resultId");
            Intrinsics.checkNotNullParameter(surpriseId, "surpriseId");
            Intrinsics.checkNotNullParameter(spokeSummary, "spokeSummary");
            Intrinsics.checkNotNullParameter(vaspokeName, "vaspokeName");
            Intrinsics.checkNotNullParameter(vaspokeMinver, "vaspokeMinver");
            Intrinsics.checkNotNullParameter(oldVersionStr, "oldVersionStr");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), packId, Integer.valueOf(i17), faceText, stickerId, Integer.valueOf(i18), Integer.valueOf(i19), resultId, surpriseId, Integer.valueOf(i26), Integer.valueOf(i27), spokeSummary, Integer.valueOf(i28), Integer.valueOf(i29), vaspokeName, vaspokeMinver, Integer.valueOf(i36), Integer.valueOf(i37), Integer.valueOf(i38), oldVersionStr, Integer.valueOf(i39), Integer.valueOf(i46));
                return;
            }
            this.faceType = i3;
            this.faceIndex = i16;
            this.packId = packId;
            this.imageType = i17;
            this.faceText = faceText;
            this.stickerId = stickerId;
            this.sourceType = i18;
            this.stickerType = i19;
            this.resultId = resultId;
            this.surpriseId = surpriseId;
            this.randomType = i26;
            this.pokeType = i27;
            this.spokeSummary = spokeSummary;
            this.doubleHit = i28;
            this.vaspokeId = i29;
            this.vaspokeName = vaspokeName;
            this.vaspokeMinver = vaspokeMinver;
            this.pokeStrength = i36;
            this.msgType = i37;
            this.faceBubbleCount = i38;
            this.oldVersionStr = oldVersionStr;
            this.pokeFlag = i39;
            this.chainCount = i46;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$c;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "origPath", "<init>", "(Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class c extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String origPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String origPath) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) origPath);
            } else {
                this.origPath = origPath;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.origPath;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof c) && Intrinsics.areEqual(this.origPath, ((c) other).origPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.origPath.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "FileElement(origPath=" + this.origPath + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$d;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "d", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "a", "()Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "<init>", "(Lcom/tencent/mobileqq/data/MarkFaceMessage;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class d extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MarkFaceMessage marketFaceMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull MarkFaceMessage marketFaceMessage) {
            super(null);
            Intrinsics.checkNotNullParameter(marketFaceMessage, "marketFaceMessage");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) marketFaceMessage);
            } else {
                this.marketFaceMessage = marketFaceMessage;
            }
        }

        @NotNull
        public final MarkFaceMessage a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MarkFaceMessage) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.marketFaceMessage;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof d) && Intrinsics.areEqual(this.marketFaceMessage, ((d) other).marketFaceMessage)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.marketFaceMessage.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "MarketFaceElement(marketFaceMessage=" + this.marketFaceMessage + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\"\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010/\u001a\u00020\u0002\u0012\b\b\u0002\u00104\u001a\u00020\b\u00a2\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010!\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010,\u001a\u0004\u0018\u00010(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b\u0015\u0010+R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b#\u0010.R\"\u00104\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$e;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "origPath", "Landroid/net/Uri;", "e", "Landroid/net/Uri;", "a", "()Landroid/net/Uri;", "imageUri", "f", "Z", "g", "()Z", CustomImageProps.QUALITY, tl.h.F, "I", "j", "()I", QCircleLpReportDc010001.KEY_SUBTYPE, "i", "k", "summary", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "b", "()F", "maxPicSize", "Lcom/tencent/qqnt/msg/data/g;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/msg/data/g;", "()Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "D", "(Ljava/lang/String;)V", "origPathMd5", "E", "l", "setFlashPic", "(Z)V", "isFlashPic", "<init>", "(Ljava/lang/String;Landroid/net/Uri;ZILjava/lang/String;FLcom/tencent/qqnt/msg/data/g;Ljava/lang/String;Z)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class e extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        @Nullable
        private final com.tencent.qqnt.msg.data.g picExtBizInfo;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private String origPathMd5;

        /* renamed from: E, reason: from kotlin metadata */
        private boolean isFlashPic;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String origPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Uri imageUri;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int subType;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String summary;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final float maxPicSize;

        public /* synthetic */ e(String str, Uri uri, boolean z16, int i3, String str2, float f16, com.tencent.qqnt.msg.data.g gVar, String str3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, uri, z16, (i16 & 8) != 0 ? 0 : i3, (i16 & 16) != 0 ? null : str2, (i16 & 32) != 0 ? 300.0f : f16, (i16 & 64) != 0 ? null : gVar, (i16 & 128) != 0 ? "" : str3, (i16 & 256) != 0 ? false : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, uri, Boolean.valueOf(z16), Integer.valueOf(i3), str2, Float.valueOf(f16), gVar, str3, Boolean.valueOf(z17), Integer.valueOf(i16), defaultConstructorMarker);
        }

        @Nullable
        public final Uri a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Uri) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.imageUri;
        }

        public final float b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
            }
            return this.maxPicSize;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.origPath;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.origPathMd5;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
                return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            if (Intrinsics.areEqual(this.origPath, eVar.origPath) && Intrinsics.areEqual(this.imageUri, eVar.imageUri) && this.quality == eVar.quality && this.subType == eVar.subType && Intrinsics.areEqual(this.summary, eVar.summary) && Float.compare(this.maxPicSize, eVar.maxPicSize) == 0 && Intrinsics.areEqual(this.picExtBizInfo, eVar.picExtBizInfo) && Intrinsics.areEqual(this.origPathMd5, eVar.origPathMd5) && this.isFlashPic == eVar.isFlashPic) {
                return true;
            }
            return false;
        }

        @Nullable
        public final com.tencent.qqnt.msg.data.g f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (com.tencent.qqnt.msg.data.g) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.picExtBizInfo;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
                return ((Integer) iPatchRedirector.redirect((short) 25, (Object) this)).intValue();
            }
            int hashCode3 = this.origPath.hashCode() * 31;
            Uri uri = this.imageUri;
            int i3 = 0;
            if (uri == null) {
                hashCode = 0;
            } else {
                hashCode = uri.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            boolean z16 = this.quality;
            int i17 = 1;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            int i19 = (((i16 + i18) * 31) + this.subType) * 31;
            String str = this.summary;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int floatToIntBits = (((i19 + hashCode2) * 31) + Float.floatToIntBits(this.maxPicSize)) * 31;
            com.tencent.qqnt.msg.data.g gVar = this.picExtBizInfo;
            if (gVar != null) {
                i3 = gVar.hashCode();
            }
            int hashCode4 = (((floatToIntBits + i3) * 31) + this.origPathMd5.hashCode()) * 31;
            boolean z17 = this.isFlashPic;
            if (!z17) {
                i17 = z17 ? 1 : 0;
            }
            return hashCode4 + i17;
        }

        public final int j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.subType;
        }

        @Nullable
        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.summary;
        }

        public final boolean l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.isFlashPic;
        }

        public final void m(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.origPathMd5 = str;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
                return (String) iPatchRedirector.redirect((short) 24, (Object) this);
            }
            return "PicElement(origPath=" + this.origPath + ", imageUri=" + this.imageUri + ", quality=" + this.quality + ", subType=" + this.subType + ", summary=" + this.summary + ", maxPicSize=" + this.maxPicSize + ", picExtBizInfo=" + this.picExtBizInfo + ", origPathMd5=" + this.origPathMd5 + ", isFlashPic=" + this.isFlashPic + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String origPath, @Nullable Uri uri, boolean z16, int i3, @Nullable String str, float f16, @Nullable com.tencent.qqnt.msg.data.g gVar, @NotNull String origPathMd5, boolean z17) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            Intrinsics.checkNotNullParameter(origPathMd5, "origPathMd5");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, origPath, uri, Boolean.valueOf(z16), Integer.valueOf(i3), str, Float.valueOf(f16), gVar, origPathMd5, Boolean.valueOf(z17));
                return;
            }
            this.origPath = origPath;
            this.imageUri = uri;
            this.quality = z16;
            this.subType = i3;
            this.summary = str;
            this.maxPicSize = f16;
            this.picExtBizInfo = gVar;
            this.origPathMd5 = origPathMd5;
            this.isFlashPic = z17;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010$\u001a\u00020\b\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010$\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010'\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$f;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "path", "", UserInfo.SEX_FEMALE, "c", "()F", "duration", "f", "I", "b", "()I", "audioType", "Ljava/util/ArrayList;", "", tl.h.F, "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "audioData", "i", "Z", "j", "()Z", "isVoiceChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "isAutoConvertText", BdhLogUtil.LogTag.Tag_Conn, "voiceChangeType", "<init>", "(Ljava/lang/String;FILjava/util/ArrayList;ZZI)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class f extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        private final int voiceChangeType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String path;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final float duration;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int audioType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Byte> audioData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final boolean isVoiceChange;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final boolean isAutoConvertText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@NotNull String path, float f16, int i3, @NotNull ArrayList<Byte> audioData, boolean z16, boolean z17, int i16) {
            super(null);
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(audioData, "audioData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, path, Float.valueOf(f16), Integer.valueOf(i3), audioData, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i16));
                return;
            }
            this.path = path;
            this.duration = f16;
            this.audioType = i3;
            this.audioData = audioData;
            this.isVoiceChange = z16;
            this.isAutoConvertText = z17;
            this.voiceChangeType = i16;
        }

        @NotNull
        public final ArrayList<Byte> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.audioData;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.audioType;
        }

        public final float c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
            }
            return this.duration;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.path;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof f)) {
                return false;
            }
            f fVar = (f) other;
            if (Intrinsics.areEqual(this.path, fVar.path) && Float.compare(this.duration, fVar.duration) == 0 && this.audioType == fVar.audioType && Intrinsics.areEqual(this.audioData, fVar.audioData) && this.isVoiceChange == fVar.isVoiceChange && this.isAutoConvertText == fVar.isAutoConvertText && this.voiceChangeType == fVar.voiceChangeType) {
                return true;
            }
            return false;
        }

        public final int f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.voiceChangeType;
        }

        public final boolean g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isAutoConvertText;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            int hashCode = ((((((this.path.hashCode() * 31) + Float.floatToIntBits(this.duration)) * 31) + this.audioType) * 31) + this.audioData.hashCode()) * 31;
            boolean z16 = this.isVoiceChange;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.isAutoConvertText;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i17 + i3) * 31) + this.voiceChangeType;
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.isVoiceChange;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "PttElement(path=" + this.path + ", duration=" + this.duration + ", audioType=" + this.audioType + ", audioData=" + this.audioData + ", isVoiceChange=" + this.isVoiceChange + ", isAutoConvertText=" + this.isAutoConvertText + ", voiceChangeType=" + this.voiceChangeType + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$g;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "d", "J", "b", "()J", "replyMsgId", "e", "c", "replyMsgSeq", "f", "Ljava/lang/String;", "()Ljava/lang/String;", "replyNick", tl.h.F, "a", "replyContent", "<init>", "(JJLjava/lang/String;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class g extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long replyMsgId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final long replyMsgSeq;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String replyNick;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String replyContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(long j3, long j16, @NotNull String replyNick, @NotNull String replyContent) {
            super(null);
            Intrinsics.checkNotNullParameter(replyNick, "replyNick");
            Intrinsics.checkNotNullParameter(replyContent, "replyContent");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), replyNick, replyContent);
                return;
            }
            this.replyMsgId = j3;
            this.replyMsgSeq = j16;
            this.replyNick = replyNick;
            this.replyContent = replyContent;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.replyContent;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.replyMsgId;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.replyMsgSeq;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.replyNick;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof g)) {
                return false;
            }
            g gVar = (g) other;
            if (this.replyMsgId == gVar.replyMsgId && this.replyMsgSeq == gVar.replyMsgSeq && Intrinsics.areEqual(this.replyNick, gVar.replyNick) && Intrinsics.areEqual(this.replyContent, gVar.replyContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return (((((androidx.fragment.app.a.a(this.replyMsgId) * 31) + androidx.fragment.app.a.a(this.replyMsgSeq)) * 31) + this.replyNick.hashCode()) * 31) + this.replyContent.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "ReplyElement(replyMsgId=" + this.replyMsgId + ", replyMsgSeq=" + this.replyMsgSeq + ", replyNick=" + this.replyNick + ", replyContent=" + this.replyContent + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$h;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "content", "e", "I", "c", "()I", "atType", "", "J", "()J", "atUid", tl.h.F, "b", "atTinyId", "i", "a", "atNtUid", "<init>", "(Ljava/lang/String;IJJLjava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class h extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String content;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int atType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final long atUid;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final long atTinyId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String atNtUid;

        public /* synthetic */ h(String str, int i3, long j3, long j16, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? 0L : j16, (i16 & 16) != 0 ? "" : str2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2, Integer.valueOf(i16), defaultConstructorMarker);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.atNtUid;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
            }
            return this.atTinyId;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.atType;
        }

        public final long e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.atUid;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof h)) {
                return false;
            }
            h hVar = (h) other;
            if (Intrinsics.areEqual(this.content, hVar.content) && this.atType == hVar.atType && this.atUid == hVar.atUid && this.atTinyId == hVar.atTinyId && Intrinsics.areEqual(this.atNtUid, hVar.atNtUid)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.content;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return (((((((this.content.hashCode() * 31) + this.atType) * 31) + androidx.fragment.app.a.a(this.atUid)) * 31) + androidx.fragment.app.a.a(this.atTinyId)) * 31) + this.atNtUid.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "TextElement(content=" + this.content + ", atType=" + this.atType + ", atUid=" + this.atUid + ", atTinyId=" + this.atTinyId + ", atNtUid=" + this.atNtUid + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull String content, int i3, long j3, long j16, @NotNull String atNtUid) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(atNtUid, "atNtUid");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, content, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), atNtUid);
                return;
            }
            this.content = content;
            this.atType = i3;
            this.atUid = j3;
            this.atTinyId = j16;
            this.atNtUid = atNtUid;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010&J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0010\u0010\u001cR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$i;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "origPath", "Landroid/net/Uri;", "e", "Landroid/net/Uri;", "b", "()Landroid/net/Uri;", "mediaUri", "f", "I", "a", "()I", "businessType", tl.h.F, "Z", "()Z", CustomImageProps.QUALITY, "i", "thumbPath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getOrigPathMd5", "setOrigPathMd5", "(Ljava/lang/String;)V", "origPathMd5", "<init>", "(Ljava/lang/String;Landroid/net/Uri;IZLjava/lang/String;Ljava/lang/String;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class i extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String origPath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Uri mediaUri;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int businessType;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean quality;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String thumbPath;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String origPathMd5;

        public /* synthetic */ i(String str, Uri uri, int i3, boolean z16, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, uri, i3, z16, str2, (i16 & 32) != 0 ? "" : str3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, uri, Integer.valueOf(i3), Boolean.valueOf(z16), str2, str3, Integer.valueOf(i16), defaultConstructorMarker);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.businessType;
        }

        @Nullable
        public final Uri b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Uri) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.mediaUri;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.origPath;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.quality;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof i)) {
                return false;
            }
            i iVar = (i) other;
            if (Intrinsics.areEqual(this.origPath, iVar.origPath) && Intrinsics.areEqual(this.mediaUri, iVar.mediaUri) && this.businessType == iVar.businessType && this.quality == iVar.quality && Intrinsics.areEqual(this.thumbPath, iVar.thumbPath) && Intrinsics.areEqual(this.origPathMd5, iVar.origPathMd5)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.thumbPath;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
            }
            int hashCode2 = this.origPath.hashCode() * 31;
            Uri uri = this.mediaUri;
            int i3 = 0;
            if (uri == null) {
                hashCode = 0;
            } else {
                hashCode = uri.hashCode();
            }
            int i16 = (((hashCode2 + hashCode) * 31) + this.businessType) * 31;
            boolean z16 = this.quality;
            int i17 = z16;
            if (z16 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            String str = this.thumbPath;
            if (str != null) {
                i3 = str.hashCode();
            }
            return ((i18 + i3) * 31) + this.origPathMd5.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return "VideoElement(origPath=" + this.origPath + ", mediaUri=" + this.mediaUri + ", businessType=" + this.businessType + ", quality=" + this.quality + ", thumbPath=" + this.thumbPath + ", origPathMd5=" + this.origPathMd5 + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull String origPath, @Nullable Uri uri, int i3, boolean z16, @Nullable String str, @NotNull String origPathMd5) {
            super(null);
            Intrinsics.checkNotNullParameter(origPath, "origPath");
            Intrinsics.checkNotNullParameter(origPathMd5, "origPathMd5");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, origPath, uri, Integer.valueOf(i3), Boolean.valueOf(z16), str, origPathMd5);
                return;
            }
            this.origPath = origPath;
            this.mediaUri = uri;
            this.businessType = i3;
            this.quality = z16;
            this.thumbPath = str;
            this.origPathMd5 = origPathMd5;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/aio/msg/element/AIOElementType$j;", "Lcom/tencent/qqnt/aio/msg/element/AIOElementType;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "getMasterActionId", "()I", "masterActionId", "e", "getGuestActionId", "guestActionId", "f", "Z", "isMultiAction", "()Z", tl.h.F, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "actionName", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final /* data */ class j extends AIOElementType {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int masterActionId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int guestActionId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean isMultiAction;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String actionName;

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.actionName;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof j)) {
                return false;
            }
            j jVar = (j) other;
            if (this.masterActionId == jVar.masterActionId && this.guestActionId == jVar.guestActionId && this.isMultiAction == jVar.isMultiAction && Intrinsics.areEqual(this.actionName, jVar.actionName)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
            }
            int i3 = ((this.masterActionId * 31) + this.guestActionId) * 31;
            boolean z16 = this.isMultiAction;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((i3 + i16) * 31) + this.actionName.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return "ZPlanActionElement(masterActionId=" + this.masterActionId + ", guestActionId=" + this.guestActionId + ", isMultiAction=" + this.isMultiAction + ", actionName=" + this.actionName + ")";
        }
    }

    public /* synthetic */ AIOElementType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    AIOElementType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
