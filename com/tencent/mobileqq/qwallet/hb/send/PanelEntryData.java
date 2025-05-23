package com.tencent.mobileqq.qwallet.hb.send;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

@Parcelize
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u0000 22\u00020\u0001:\u0001!B?\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0004\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b0\u00101J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\"\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018R\u0019\u0010%\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R*\u0010/\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "e", "I", "getType", "()I", "type", "f", "getTitle", "title", h.F, "b", "icon", "i", "a", "aioScene", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getParamsString", "paramsString", "Lorg/json/JSONObject;", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "getParams$annotations", "()V", "params", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "D", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class PanelEntryData implements Parcelable {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private JSONObject params;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String icon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final int aioScene;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String paramsString;

    @NotNull
    public static final Parcelable.Creator<PanelEntryData> CREATOR = new b();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class b implements Parcelable.Creator<PanelEntryData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final PanelEntryData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PanelEntryData(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final PanelEntryData[] newArray(int i3) {
            return new PanelEntryData[i3];
        }
    }

    public PanelEntryData(@NotNull String id5, int i3, @NotNull String title, @NotNull String icon, int i16, @Nullable String str) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = id5;
        this.type = i3;
        this.title = title;
        this.icon = icon;
        this.aioScene = i16;
        this.paramsString = str;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            this.params = new JSONObject(str);
        } catch (JSONException e16) {
            QLog.e("PanelEntryData", 1, "getParams: error ", e16);
        }
    }

    /* renamed from: a, reason: from getter */
    public final int getAioScene() {
        return this.aioScene;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final JSONObject getParams() {
        return this.params;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PanelEntryData)) {
            return false;
        }
        PanelEntryData panelEntryData = (PanelEntryData) other;
        if (Intrinsics.areEqual(this.id, panelEntryData.id) && this.type == panelEntryData.type && Intrinsics.areEqual(this.title, panelEntryData.title) && Intrinsics.areEqual(this.icon, panelEntryData.icon) && this.aioScene == panelEntryData.aioScene && Intrinsics.areEqual(this.paramsString, panelEntryData.paramsString)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((((this.id.hashCode() * 31) + this.type) * 31) + this.title.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.aioScene) * 31;
        String str = this.paramsString;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "PanelEntryData(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", icon=" + this.icon + ", aioScene=" + this.aioScene + ", paramsString=" + this.paramsString + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeString(this.title);
        parcel.writeString(this.icon);
        parcel.writeInt(this.aioScene);
        parcel.writeString(this.paramsString);
    }

    public /* synthetic */ PanelEntryData(String str, int i3, String str2, String str3, int i16, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, i3, str2, str3, (i17 & 16) != 0 ? 0 : i16, (i17 & 32) != 0 ? null : str4);
    }
}
