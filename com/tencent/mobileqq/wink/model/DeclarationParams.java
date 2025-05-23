package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$ShootLBS;
import feedcloud.FeedCloudMeta$SourceInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B/\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b*\u0010,J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\t\u0010\f\u001a\u00020\nH\u00c6\u0003J\t\u0010\r\u001a\u00020\nH\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003R\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0013\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "component1", "component2", "Lfeedcloud/FeedCloudMeta$ShootLBS;", "component3", "Lfeedcloud/FeedCloudMeta$SourceInfo;", "component4", "id", "name", "shootLbs", "sourceInfo", "copy", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getName", "Lfeedcloud/FeedCloudMeta$ShootLBS;", "getShootLbs", "()Lfeedcloud/FeedCloudMeta$ShootLBS;", "setShootLbs", "(Lfeedcloud/FeedCloudMeta$ShootLBS;)V", "Lfeedcloud/FeedCloudMeta$SourceInfo;", "getSourceInfo", "()Lfeedcloud/FeedCloudMeta$SourceInfo;", "setSourceInfo", "(Lfeedcloud/FeedCloudMeta$SourceInfo;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lfeedcloud/FeedCloudMeta$ShootLBS;Lfeedcloud/FeedCloudMeta$SourceInfo;)V", "(Landroid/os/Parcel;)V", "Companion", "b", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class DeclarationParams implements Parcelable, Serializable {

    @NotNull
    private final String id;

    @NotNull
    private final String name;

    @Nullable
    private FeedCloudMeta$ShootLBS shootLbs;

    @Nullable
    private FeedCloudMeta$SourceInfo sourceInfo;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final Parcelable.Creator<DeclarationParams> CREATOR = new a();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/model/DeclarationParams$a", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Parcelable.Creator<DeclarationParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DeclarationParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DeclarationParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeclarationParams[] newArray(int size) {
            return new DeclarationParams[size];
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0003H\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/model/DeclarationParams$b;", "", "Lorg/json/JSONObject;", "", "key", "a", "str", "Lcom/tencent/mobileqq/wink/model/DeclarationParams;", "b", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "JSON_KEY_CITY", "Ljava/lang/String;", "JSON_KEY_COUNTRY", "JSON_KEY_FEED_ID", "JSON_KEY_ID", "JSON_KEY_NAME", "JSON_KEY_PROVINCE", "JSON_KEY_SHOOT_TIME", "JSON_KEY_UID", "TAG", "<init>", "()V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.DeclarationParams$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(JSONObject jSONObject, String str) {
            boolean z16;
            String optString = jSONObject.optString(str);
            if (optString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return null;
            }
            return optString;
        }

        @JvmStatic
        @Nullable
        public final DeclarationParams b(@NotNull String str) {
            FeedCloudMeta$ShootLBS shootLbs;
            Intrinsics.checkNotNullParameter(str, "str");
            try {
                JSONObject jSONObject = new JSONObject(str);
                QLog.d("DeclarationParams", 1, "revertFromString " + str);
                String optString = jSONObject.optString("id");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(JSON_KEY_ID)");
                String optString2 = jSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(JSON_KEY_NAME)");
                DeclarationParams declarationParams = new DeclarationParams(optString, optString2, null, null, 12, null);
                long optLong = jSONObject.optLong("shootTime", -1L);
                Companion companion = DeclarationParams.INSTANCE;
                String a16 = companion.a(jSONObject, "country");
                String a17 = companion.a(jSONObject, "province");
                String a18 = companion.a(jSONObject, "city");
                String a19 = companion.a(jSONObject, "feed_id");
                String a26 = companion.a(jSONObject, "uid");
                if (optLong != -1) {
                    FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = new FeedCloudMeta$ShootLBS();
                    feedCloudMeta$ShootLBS.shoot_time.set(optLong);
                    declarationParams.setShootLbs(feedCloudMeta$ShootLBS);
                    if (a16 != null && (shootLbs = declarationParams.getShootLbs()) != null) {
                        shootLbs.country.set(a16);
                        if (a17 != null) {
                            shootLbs.province.set(a17);
                        }
                        if (a18 != null) {
                            shootLbs.city.set(a18);
                        }
                    }
                }
                if (a19 != null) {
                    FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = new FeedCloudMeta$SourceInfo();
                    feedCloudMeta$SourceInfo.feed_id.set(a19);
                    if (a26 != null) {
                        feedCloudMeta$SourceInfo.ec_uid.set(a26);
                    }
                    declarationParams.setSourceInfo(feedCloudMeta$SourceInfo);
                }
                QLog.d("DeclarationParams", 1, "revertFromString finish... declarationParams:" + declarationParams);
                return declarationParams;
            } catch (JSONException e16) {
                QLog.e("DeclarationParams", 1, e16, new Object[0]);
                return null;
            }
        }

        Companion() {
        }
    }

    public DeclarationParams(@NotNull String id5, @NotNull String name, @Nullable FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS, @Nullable FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id5;
        this.name = name;
        this.shootLbs = feedCloudMeta$ShootLBS;
        this.sourceInfo = feedCloudMeta$SourceInfo;
    }

    public static /* synthetic */ DeclarationParams copy$default(DeclarationParams declarationParams, String str, String str2, FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS, FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = declarationParams.id;
        }
        if ((i3 & 2) != 0) {
            str2 = declarationParams.name;
        }
        if ((i3 & 4) != 0) {
            feedCloudMeta$ShootLBS = declarationParams.shootLbs;
        }
        if ((i3 & 8) != 0) {
            feedCloudMeta$SourceInfo = declarationParams.sourceInfo;
        }
        return declarationParams.copy(str, str2, feedCloudMeta$ShootLBS, feedCloudMeta$SourceInfo);
    }

    @JvmStatic
    @Nullable
    public static final DeclarationParams revertFromString(@NotNull String str) {
        return INSTANCE.b(str);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final FeedCloudMeta$ShootLBS getShootLbs() {
        return this.shootLbs;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final FeedCloudMeta$SourceInfo getSourceInfo() {
        return this.sourceInfo;
    }

    @NotNull
    public final DeclarationParams copy(@NotNull String id5, @NotNull String name, @Nullable FeedCloudMeta$ShootLBS shootLbs, @Nullable FeedCloudMeta$SourceInfo sourceInfo) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new DeclarationParams(id5, name, shootLbs, sourceInfo);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeclarationParams)) {
            return false;
        }
        DeclarationParams declarationParams = (DeclarationParams) other;
        if (Intrinsics.areEqual(this.id, declarationParams.id) && Intrinsics.areEqual(this.name, declarationParams.name) && Intrinsics.areEqual(this.shootLbs, declarationParams.shootLbs) && Intrinsics.areEqual(this.sourceInfo, declarationParams.sourceInfo)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final FeedCloudMeta$ShootLBS getShootLbs() {
        return this.shootLbs;
    }

    @Nullable
    public final FeedCloudMeta$SourceInfo getSourceInfo() {
        return this.sourceInfo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.id.hashCode() * 31) + this.name.hashCode()) * 31;
        FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = this.shootLbs;
        int i3 = 0;
        if (feedCloudMeta$ShootLBS == null) {
            hashCode = 0;
        } else {
            hashCode = feedCloudMeta$ShootLBS.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = this.sourceInfo;
        if (feedCloudMeta$SourceInfo != null) {
            i3 = feedCloudMeta$SourceInfo.hashCode();
        }
        return i16 + i3;
    }

    public final void setShootLbs(@Nullable FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS) {
        this.shootLbs = feedCloudMeta$ShootLBS;
    }

    public final void setSourceInfo(@Nullable FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo) {
        this.sourceInfo = feedCloudMeta$SourceInfo;
    }

    @NotNull
    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("name", this.name);
        FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = this.shootLbs;
        if (feedCloudMeta$ShootLBS != null) {
            if (feedCloudMeta$ShootLBS.shoot_time.get() != -1) {
                jSONObject.put("shootTime", feedCloudMeta$ShootLBS.shoot_time.get());
            }
            PBStringField country = feedCloudMeta$ShootLBS.country;
            if (country != null) {
                Intrinsics.checkNotNullExpressionValue(country, "country");
                jSONObject.put("country", country.get());
            }
            PBStringField province = feedCloudMeta$ShootLBS.province;
            if (province != null) {
                Intrinsics.checkNotNullExpressionValue(province, "province");
                jSONObject.put("province", province.get());
            }
            PBStringField city = feedCloudMeta$ShootLBS.city;
            if (city != null) {
                Intrinsics.checkNotNullExpressionValue(city, "city");
                jSONObject.put("city", city.get());
            }
        }
        FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = this.sourceInfo;
        if (feedCloudMeta$SourceInfo != null) {
            PBStringField feed_id = feedCloudMeta$SourceInfo.feed_id;
            if (feed_id != null) {
                Intrinsics.checkNotNullExpressionValue(feed_id, "feed_id");
                jSONObject.put("feed_id", feed_id.get());
            }
            PBStringField ec_uid = feedCloudMeta$SourceInfo.ec_uid;
            if (ec_uid != null) {
                Intrinsics.checkNotNullExpressionValue(ec_uid, "ec_uid");
                jSONObject.put("uid", ec_uid.get());
            }
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026   }\n        }.toString()");
        return jSONObject2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int i3;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = this.shootLbs;
        int i16 = 0;
        if (feedCloudMeta$ShootLBS != null) {
            i3 = feedCloudMeta$ShootLBS.getSerializedSize();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        if (i3 > 0) {
            FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS2 = this.shootLbs;
            Intrinsics.checkNotNull(feedCloudMeta$ShootLBS2);
            parcel.writeByteArray(feedCloudMeta$ShootLBS2.toByteArray());
        }
        FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = this.sourceInfo;
        if (feedCloudMeta$SourceInfo != null) {
            i16 = feedCloudMeta$SourceInfo.getSerializedSize();
        }
        parcel.writeInt(i16);
        if (i16 > 0) {
            FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo2 = this.sourceInfo;
            Intrinsics.checkNotNull(feedCloudMeta$SourceInfo2);
            parcel.writeByteArray(feedCloudMeta$SourceInfo2.toByteArray());
        }
    }

    public /* synthetic */ DeclarationParams(String str, String str2, FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS, FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? null : feedCloudMeta$ShootLBS, (i3 & 8) != 0 ? null : feedCloudMeta$SourceInfo);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DeclarationParams(@NotNull Parcel parcel) {
        this(r3, r0 == null ? "" : r0, null, null, 12, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            FeedCloudMeta$ShootLBS feedCloudMeta$ShootLBS = new FeedCloudMeta$ShootLBS();
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            feedCloudMeta$ShootLBS.mergeFrom(bArr);
            this.shootLbs = feedCloudMeta$ShootLBS;
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            FeedCloudMeta$SourceInfo feedCloudMeta$SourceInfo = new FeedCloudMeta$SourceInfo();
            byte[] bArr2 = new byte[readInt2];
            parcel.readByteArray(bArr2);
            feedCloudMeta$SourceInfo.mergeFrom(bArr2);
            this.sourceInfo = feedCloudMeta$SourceInfo;
        }
    }
}
