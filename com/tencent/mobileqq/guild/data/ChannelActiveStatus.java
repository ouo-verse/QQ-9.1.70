package com.tencent.mobileqq.guild.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelStateInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b>\u0010?B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b>\u0010@J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\"\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\"\u00103\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u000b\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR2\u0010=\u001a\u0012\u0012\u0004\u0012\u00020504j\b\u0012\u0004\u0012\u000205`68\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/data/ChannelActiveStatus;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "e", "getChannelId", "setChannelId", "channelId", "f", "I", "getChannelType", "()I", "setChannelType", "(I)V", "channelType", "", tl.h.F, "J", "getChannelStateSeq", "()J", "setChannelStateSeq", "(J)V", "channelStateSeq", "i", "getChannelState", "setChannelState", "channelState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getActiveIconResId", "setActiveIconResId", "activeIconResId", BdhLogUtil.LogTag.Tag_Conn, "getPriority", "setPriority", "priority", "D", "getHighLightText", "setHighLightText", "highLightText", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelStateInfo;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "getChannelStateList", "()Ljava/util/ArrayList;", "setChannelStateList", "(Ljava/util/ArrayList;)V", "channelStateList", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ChannelActiveStatus implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private int priority;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String highLightText;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<IGProChannelStateInfo> channelStateList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int channelType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long channelStateSeq;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @ChannelActiveState
    private int channelState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int activeIconResId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/data/ChannelActiveStatus$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/data/ChannelActiveStatus;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/data/ChannelActiveStatus;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.data.ChannelActiveStatus$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements Parcelable.Creator<ChannelActiveStatus> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ChannelActiveStatus createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChannelActiveStatus(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChannelActiveStatus[] newArray(int size) {
            return new ChannelActiveStatus[size];
        }

        Companion() {
        }
    }

    public ChannelActiveStatus() {
        this.guildId = "";
        this.channelId = "";
        this.channelStateSeq = -1L;
        this.activeIconResId = -1;
        this.priority = Integer.MAX_VALUE;
        this.highLightText = "";
        this.channelStateList = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.guildId);
        parcel.writeString(this.channelId);
        parcel.writeInt(this.channelType);
        parcel.writeLong(this.channelStateSeq);
        parcel.writeInt(this.channelState);
        parcel.writeInt(this.activeIconResId);
        parcel.writeInt(this.priority);
        parcel.writeString(this.highLightText);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChannelActiveStatus(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.guildId = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.channelId = readString2 == null ? "" : readString2;
        this.channelType = parcel.readInt();
        this.channelStateSeq = parcel.readLong();
        this.channelState = parcel.readInt();
        this.activeIconResId = parcel.readInt();
        this.priority = parcel.readInt();
        String readString3 = parcel.readString();
        this.highLightText = readString3 != null ? readString3 : "";
    }
}
