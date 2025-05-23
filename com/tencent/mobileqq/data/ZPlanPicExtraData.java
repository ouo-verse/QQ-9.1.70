package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ZPlanStickerMessageInfo;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb$ZPlanStickerMessageInfo;

@Parcelize
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "Landroid/os/Parcelable;", "id", "", "name", "", "playNumber", "actionType", "peerUin", "", "bytesPicUrl", "reserveInfo", "width", "height", "(ILjava/lang/String;IIJLjava/lang/String;Ljava/lang/String;II)V", "getActionType", "()I", "getBytesPicUrl", "()Ljava/lang/String;", "getHeight", "getId", "getName", "getPeerUin", "()J", "getPlayNumber", "getReserveInfo", "getWidth", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "QQSystemEmoji-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class ZPlanPicExtraData implements Parcelable {
    private final int actionType;

    @Nullable
    private final String bytesPicUrl;
    private final int height;
    private final int id;

    @Nullable
    private final String name;
    private final long peerUin;
    private final int playNumber;

    @Nullable
    private final String reserveInfo;
    private final int width;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ZPlanPicExtraData> CREATOR = new Creator();

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0007J:\u0010\u0013\u001a\u0004\u0018\u00010\u000e2.\u0010\u0014\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0016H\u0007J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/data/ZPlanPicExtraData$Companion;", "", "()V", "ACTION_TYPE", "", "BYTES_PIC_URL", "HEIGHT", "ID", "NAME", "PEER_UIN", "PLAY_NUMBER", "RESERVE_INFO", "WIDTH", "parseC2CInfoToZPlanPicExtraData", "Lcom/tencent/mobileqq/data/ZPlanPicExtraData;", "info", "Ltencent/im/msg/hummer/resv6/NotOnlineImageExtPb$ZPlanStickerMessageInfo;", "parseCustomInfoToZPlanPicExtraData", "Ltencent/im/msg/hummer/resv3/CustomFaceExtPb$ZPlanStickerMessageInfo;", "parseMapToZPlanPicExtraData", "mapData", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "parseZPlanPicExtraDataToC2CInfo", "data", "parseZPlanPicExtraDataToQunInfo", "QQSystemEmoji-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final ZPlanPicExtraData parseC2CInfoToZPlanPicExtraData(@Nullable NotOnlineImageExtPb$ZPlanStickerMessageInfo info) {
            String str;
            int i3;
            int i16;
            long j3;
            String str2;
            String str3;
            int i17;
            int i18;
            if (info == null) {
                return null;
            }
            int i19 = info.uint32_action_id.get();
            if (!info.bytes_action_name.has()) {
                str = "";
            } else {
                str = info.bytes_action_name.get().toStringUtf8();
            }
            if (info.uint32_player_number.has()) {
                i3 = info.uint32_player_number.get();
            } else {
                i3 = 1;
            }
            int i26 = i3;
            if (info.uint32_action_type.has()) {
                i16 = info.uint32_action_type.get();
            } else {
                i16 = -1;
            }
            int i27 = i16;
            if (info.uint64_peer_uin.has()) {
                j3 = info.uint64_peer_uin.get();
            } else {
                j3 = -1;
            }
            if (!info.bytes_pic_url.has()) {
                str2 = "";
            } else {
                str2 = info.bytes_pic_url.get().toStringUtf8();
            }
            if (!info.bytes_reserve_info.has()) {
                str3 = "";
            } else {
                str3 = info.bytes_reserve_info.get().toStringUtf8();
            }
            if (info.uint32_meme_width.has()) {
                i17 = info.uint32_meme_width.get();
            } else {
                i17 = 0;
            }
            if (info.uint32_meme_height.has()) {
                i18 = info.uint32_meme_height.get();
            } else {
                i18 = 0;
            }
            return new ZPlanPicExtraData(i19, str, i26, i27, j3, str2, str3, i17, i18);
        }

        @JvmStatic
        @Nullable
        public final ZPlanPicExtraData parseCustomInfoToZPlanPicExtraData(@Nullable CustomFaceExtPb$ZPlanStickerMessageInfo info) {
            String str;
            int i3;
            int i16;
            long j3;
            String str2;
            String str3;
            int i17;
            int i18;
            if (info == null) {
                return null;
            }
            int i19 = info.uint32_action_id.get();
            if (!info.bytes_action_name.has()) {
                str = "";
            } else {
                str = info.bytes_action_name.get().toStringUtf8();
            }
            if (info.uint32_player_number.has()) {
                i3 = info.uint32_player_number.get();
            } else {
                i3 = 1;
            }
            int i26 = i3;
            if (info.uint32_action_type.has()) {
                i16 = info.uint32_action_type.get();
            } else {
                i16 = -1;
            }
            int i27 = i16;
            if (info.uint64_peer_uin.has()) {
                j3 = info.uint64_peer_uin.get();
            } else {
                j3 = -1;
            }
            if (!info.bytes_pic_url.has()) {
                str2 = "";
            } else {
                str2 = info.bytes_pic_url.get().toStringUtf8();
            }
            if (!info.bytes_reserve_info.has()) {
                str3 = "";
            } else {
                str3 = info.bytes_reserve_info.get().toStringUtf8();
            }
            if (info.uint32_meme_width.has()) {
                i17 = info.uint32_meme_width.get();
            } else {
                i17 = 0;
            }
            if (info.uint32_meme_height.has()) {
                i18 = info.uint32_meme_height.get();
            } else {
                i18 = 0;
            }
            return new ZPlanPicExtraData(i19, str, i26, i27, j3, str2, str3, i17, i18);
        }

        @JvmStatic
        @Nullable
        public final ZPlanPicExtraData parseMapToZPlanPicExtraData(@Nullable HashMap<String, String> mapData) {
            String str;
            String str2;
            String str3;
            int i3;
            int i16;
            long j3;
            int i17;
            int i18;
            if (mapData == null) {
                return null;
            }
            String str4 = mapData.get("id");
            String str5 = mapData.get("name");
            String str6 = mapData.get("player_number");
            String str7 = mapData.get("action_type");
            if (!mapData.containsKey(ProtocolDownloaderConstants.HEADER_FRIEND_UIN)) {
                str = "";
            } else {
                str = mapData.get(ProtocolDownloaderConstants.HEADER_FRIEND_UIN);
            }
            if (!mapData.containsKey("bytes_pic_url")) {
                str2 = "";
            } else {
                str2 = mapData.get("bytes_pic_url");
            }
            if (!mapData.containsKey("reserve_info")) {
                str3 = "";
            } else {
                str3 = mapData.get("reserve_info");
            }
            String str8 = mapData.get("width");
            String str9 = mapData.get("height");
            if (!TextUtils.isEmpty(str6)) {
                Intrinsics.checkNotNull(str6);
                i3 = Integer.parseInt(str6);
            } else {
                i3 = 1;
            }
            if (!TextUtils.isEmpty(str7)) {
                Intrinsics.checkNotNull(str7);
                i16 = Integer.parseInt(str7);
            } else {
                i16 = -1;
            }
            int i19 = i16;
            if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                j3 = Integer.parseInt(str);
            } else {
                j3 = -1;
            }
            long j16 = j3;
            if (!TextUtils.isEmpty(str8)) {
                Intrinsics.checkNotNull(str8);
                i17 = Integer.parseInt(str8);
            } else {
                i17 = 0;
            }
            if (!TextUtils.isEmpty(str9)) {
                Intrinsics.checkNotNull(str9);
                i18 = Integer.parseInt(str9);
            } else {
                i18 = 0;
            }
            Intrinsics.checkNotNull(str4);
            return new ZPlanPicExtraData(Integer.parseInt(str4), str5, i3, i19, j16, str2, str3, i17, i18);
        }

        @JvmStatic
        @Nullable
        public final NotOnlineImageExtPb$ZPlanStickerMessageInfo parseZPlanPicExtraDataToC2CInfo(@Nullable ZPlanPicExtraData data) {
            if (data == null) {
                return null;
            }
            NotOnlineImageExtPb$ZPlanStickerMessageInfo notOnlineImageExtPb$ZPlanStickerMessageInfo = new NotOnlineImageExtPb$ZPlanStickerMessageInfo();
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint32_action_id.set(data.getId());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.bytes_action_name.set(ByteStringMicro.copyFromUtf8(data.getName()));
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint32_player_number.set(data.getPlayNumber());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint32_action_type.set(data.getActionType());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint64_peer_uin.set(data.getPeerUin());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(data.getBytesPicUrl()));
            notOnlineImageExtPb$ZPlanStickerMessageInfo.bytes_reserve_info.set(ByteStringMicro.copyFromUtf8(data.getReserveInfo()));
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint32_meme_width.set(data.getWidth());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.uint32_meme_height.set(data.getHeight());
            notOnlineImageExtPb$ZPlanStickerMessageInfo.setHasFlag(true);
            return notOnlineImageExtPb$ZPlanStickerMessageInfo;
        }

        @JvmStatic
        @Nullable
        public final CustomFaceExtPb$ZPlanStickerMessageInfo parseZPlanPicExtraDataToQunInfo(@Nullable ZPlanPicExtraData data) {
            if (data == null) {
                return null;
            }
            CustomFaceExtPb$ZPlanStickerMessageInfo customFaceExtPb$ZPlanStickerMessageInfo = new CustomFaceExtPb$ZPlanStickerMessageInfo();
            customFaceExtPb$ZPlanStickerMessageInfo.uint32_action_id.set(data.getId());
            customFaceExtPb$ZPlanStickerMessageInfo.bytes_action_name.set(ByteStringMicro.copyFromUtf8(data.getName()));
            customFaceExtPb$ZPlanStickerMessageInfo.uint32_player_number.set(data.getPlayNumber());
            customFaceExtPb$ZPlanStickerMessageInfo.uint32_action_type.set(data.getActionType());
            customFaceExtPb$ZPlanStickerMessageInfo.uint64_peer_uin.set(data.getPeerUin());
            customFaceExtPb$ZPlanStickerMessageInfo.bytes_pic_url.set(ByteStringMicro.copyFromUtf8(data.getBytesPicUrl()));
            customFaceExtPb$ZPlanStickerMessageInfo.bytes_reserve_info.set(ByteStringMicro.copyFromUtf8(data.getReserveInfo()));
            customFaceExtPb$ZPlanStickerMessageInfo.uint32_meme_width.set(data.getWidth());
            customFaceExtPb$ZPlanStickerMessageInfo.uint32_meme_height.set(data.getHeight());
            customFaceExtPb$ZPlanStickerMessageInfo.setHasFlag(true);
            return customFaceExtPb$ZPlanStickerMessageInfo;
        }

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class Creator implements Parcelable.Creator<ZPlanPicExtraData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ZPlanPicExtraData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ZPlanPicExtraData(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ZPlanPicExtraData[] newArray(int i3) {
            return new ZPlanPicExtraData[i3];
        }
    }

    public ZPlanPicExtraData(int i3, @Nullable String str, int i16, int i17, long j3, @Nullable String str2, @Nullable String str3, int i18, int i19) {
        this.id = i3;
        this.name = str;
        this.playNumber = i16;
        this.actionType = i17;
        this.peerUin = j3;
        this.bytesPicUrl = str2;
        this.reserveInfo = str3;
        this.width = i18;
        this.height = i19;
    }

    @JvmStatic
    @Nullable
    public static final ZPlanPicExtraData parseC2CInfoToZPlanPicExtraData(@Nullable NotOnlineImageExtPb$ZPlanStickerMessageInfo notOnlineImageExtPb$ZPlanStickerMessageInfo) {
        return INSTANCE.parseC2CInfoToZPlanPicExtraData(notOnlineImageExtPb$ZPlanStickerMessageInfo);
    }

    @JvmStatic
    @Nullable
    public static final ZPlanPicExtraData parseCustomInfoToZPlanPicExtraData(@Nullable CustomFaceExtPb$ZPlanStickerMessageInfo customFaceExtPb$ZPlanStickerMessageInfo) {
        return INSTANCE.parseCustomInfoToZPlanPicExtraData(customFaceExtPb$ZPlanStickerMessageInfo);
    }

    @JvmStatic
    @Nullable
    public static final ZPlanPicExtraData parseMapToZPlanPicExtraData(@Nullable HashMap<String, String> hashMap) {
        return INSTANCE.parseMapToZPlanPicExtraData(hashMap);
    }

    @JvmStatic
    @Nullable
    public static final NotOnlineImageExtPb$ZPlanStickerMessageInfo parseZPlanPicExtraDataToC2CInfo(@Nullable ZPlanPicExtraData zPlanPicExtraData) {
        return INSTANCE.parseZPlanPicExtraDataToC2CInfo(zPlanPicExtraData);
    }

    @JvmStatic
    @Nullable
    public static final CustomFaceExtPb$ZPlanStickerMessageInfo parseZPlanPicExtraDataToQunInfo(@Nullable ZPlanPicExtraData zPlanPicExtraData) {
        return INSTANCE.parseZPlanPicExtraDataToQunInfo(zPlanPicExtraData);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getActionType() {
        return this.actionType;
    }

    @Nullable
    public final String getBytesPicUrl() {
        return this.bytesPicUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final long getPeerUin() {
        return this.peerUin;
    }

    public final int getPlayNumber() {
        return this.playNumber;
    }

    @Nullable
    public final String getReserveInfo() {
        return this.reserveInfo;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.playNumber);
        parcel.writeInt(this.actionType);
        parcel.writeLong(this.peerUin);
        parcel.writeString(this.bytesPicUrl);
        parcel.writeString(this.reserveInfo);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    public /* synthetic */ ZPlanPicExtraData(int i3, String str, int i16, int i17, long j3, String str2, String str3, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, i16, i17, (i26 & 16) != 0 ? 0L : j3, (i26 & 32) != 0 ? null : str2, (i26 & 64) != 0 ? null : str3, (i26 & 128) != 0 ? 0 : i18, (i26 & 256) != 0 ? 0 : i19);
    }
}
