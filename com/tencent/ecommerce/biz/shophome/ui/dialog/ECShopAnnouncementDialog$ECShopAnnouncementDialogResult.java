package com.tencent.ecommerce.biz.shophome.ui.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult", "Landroid/os/Parcelable;", "<init>", "()V", "Cancel", "PageReady", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult$PageReady;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult$Cancel;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECShopAnnouncementDialog$ECShopAnnouncementDialogResult implements Parcelable {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult$Cancel;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class Cancel extends ECShopAnnouncementDialog$ECShopAnnouncementDialogResult {

        /* renamed from: d, reason: collision with root package name */
        public static final Cancel f104356d = new Cancel();
        public static final Parcelable.Creator<Cancel> CREATOR = new a();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static class a implements Parcelable.Creator<Cancel> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Cancel createFromParcel(Parcel parcel) {
                if (parcel.readInt() != 0) {
                    return Cancel.f104356d;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Cancel[] newArray(int i3) {
                return new Cancel[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Cancel() {
            super(null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(1);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00d6\u0001\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult$PageReady;", "Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopAnnouncementDialog$ECShopAnnouncementDialogResult;", "()V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class PageReady extends ECShopAnnouncementDialog$ECShopAnnouncementDialogResult {

        /* renamed from: d, reason: collision with root package name */
        public static final PageReady f104357d = new PageReady();
        public static final Parcelable.Creator<PageReady> CREATOR = new a();

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
        /* loaded from: classes31.dex */
        public static class a implements Parcelable.Creator<PageReady> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final PageReady createFromParcel(Parcel parcel) {
                if (parcel.readInt() != 0) {
                    return PageReady.f104357d;
                }
                return null;
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final PageReady[] newArray(int i3) {
                return new PageReady[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        PageReady() {
            super(null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            parcel.writeInt(1);
        }
    }

    ECShopAnnouncementDialog$ECShopAnnouncementDialogResult() {
    }

    public /* synthetic */ ECShopAnnouncementDialog$ECShopAnnouncementDialogResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
