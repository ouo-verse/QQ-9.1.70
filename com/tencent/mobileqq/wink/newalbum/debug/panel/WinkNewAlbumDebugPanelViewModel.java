package com.tencent.mobileqq.wink.newalbum.debug.panel;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b#\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0011\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\u0014\u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "storyID", "e", "getAlbumName", AEEditorConstants.ALBUMNAME, "f", "I", "b", "()I", "g", "(I)V", "currentLoop", "", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugBaseModel;", h.F, "Ljava/util/List;", "a", "()Ljava/util/List;", "(Ljava/util/List;)V", "baseModelList", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumDebugPanelViewModel implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String storyID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String albumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentLoop;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<WinkNewAlbumDebugBaseModel> baseModelList;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/newalbum/debug/panel/WinkNewAlbumDebugPanelViewModel;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.debug.panel.WinkNewAlbumDebugPanelViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<WinkNewAlbumDebugPanelViewModel> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumDebugPanelViewModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new WinkNewAlbumDebugPanelViewModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkNewAlbumDebugPanelViewModel[] newArray(int size) {
            return new WinkNewAlbumDebugPanelViewModel[size];
        }

        Companion() {
        }
    }

    public WinkNewAlbumDebugPanelViewModel() {
        List<WinkNewAlbumDebugBaseModel> emptyList;
        this.storyID = "";
        this.albumName = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.baseModelList = emptyList;
    }

    @NotNull
    public final List<WinkNewAlbumDebugBaseModel> a() {
        return this.baseModelList;
    }

    /* renamed from: b, reason: from getter */
    public final int getCurrentLoop() {
        return this.currentLoop;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void f(@NotNull List<WinkNewAlbumDebugBaseModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.baseModelList = list;
    }

    public final void g(int i3) {
        this.currentLoop = i3;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storyID = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.storyID);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.currentLoop);
        parcel.writeTypedList(this.baseModelList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumDebugPanelViewModel(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.storyID = readString == null ? this.storyID : readString;
        String readString2 = parcel.readString();
        this.albumName = readString2 == null ? this.albumName : readString2;
        this.currentLoop = parcel.readInt();
        List<WinkNewAlbumDebugBaseModel> createTypedArrayList = parcel.createTypedArrayList(WinkNewAlbumDebugBaseModel.INSTANCE);
        this.baseModelList = createTypedArrayList == null ? this.baseModelList : createTypedArrayList;
    }
}
