package com.tencent.mobileqq.guild.feed.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001c2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShowBusinessDialogEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "getJumpGuildParam", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "setJumpGuildParam", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;)V", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedShowBusinessDialogEvent extends SimpleBaseEvent implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private JumpGuildParam jumpGuildParam;

    @Nullable
    private String type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShowBusinessDialogEvent$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShowBusinessDialogEvent;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/feed/event/GuildFeedShowBusinessDialogEvent;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.event.GuildFeedShowBusinessDialogEvent$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion implements Parcelable.Creator<GuildFeedShowBusinessDialogEvent> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildFeedShowBusinessDialogEvent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new GuildFeedShowBusinessDialogEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildFeedShowBusinessDialogEvent[] newArray(int size) {
            return new GuildFeedShowBusinessDialogEvent[size];
        }

        Companion() {
        }
    }

    public GuildFeedShowBusinessDialogEvent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final JumpGuildParam getJumpGuildParam() {
        return this.jumpGuildParam;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public final void setJumpGuildParam(@Nullable JumpGuildParam jumpGuildParam) {
        this.jumpGuildParam = jumpGuildParam;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeParcelable(this.jumpGuildParam, flags);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildFeedShowBusinessDialogEvent(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.type = parcel.readString();
        this.jumpGuildParam = (JumpGuildParam) parcel.readParcelable(JumpGuildParam.class.getClassLoader());
    }
}
