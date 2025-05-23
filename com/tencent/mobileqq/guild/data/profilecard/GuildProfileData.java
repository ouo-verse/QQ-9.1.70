package com.tencent.mobileqq.guild.data.profilecard;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserPublishedFeedSummary;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes13.dex */
public class GuildProfileData implements Parcelable {
    public static final Parcelable.Creator<GuildProfileData> CREATOR = new a();
    public static final byte FLAG_DIRECT_MESSAGE_CHAT = 1;
    public static final byte FLAG_GUILD_CHAT = 0;
    public static final String KEY_CHANNEL_DATA = "key_channel_data";
    public static final String KEY_IS_FROM_STANDALONE = "KEY_IS_FROM_STANDALONE";
    public static final String KEY_SOURCE_FROM = "key_source_from";
    public static final int TYPE_AUDIO = 1;
    public static final int TYPE_LIVE = 2;
    public static final int TYPE_MEDIA_GIFT_LIST_FROM_H5 = 5;
    public static final int TYPE_META_CHANNEL = 3;
    public static final int TYPE_OTHER = 6;
    public static final int TYPE_SCHEME = 4;
    public static final int TYPE_TEXT = 0;
    private Bundle mExtras;
    private FeedImpeachData mFeedImpeachData;
    private GuildBaseProfileData mGuildBaseProfileData;
    private ev mUserProfileInfo;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes13.dex */
    @interface ProfileType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes13.dex */
    @interface SceneType {
    }

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildProfileData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildProfileData createFromParcel(Parcel parcel) {
            return new GuildProfileData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildProfileData[] newArray(int i3) {
            return new GuildProfileData[i3];
        }
    }

    public GuildProfileData(String str, @Nullable String str2, String str3, int i3, int i16) {
        this.mExtras = new Bundle();
        this.mGuildBaseProfileData = new GuildBaseProfileData(str, str2, str3, i3, i16);
    }

    public static int getSceneTypeBySource(String str, String str2, int i3) {
        if (TextUtils.equals(str, "partner") && TextUtils.equals(str2, IndividuationUrlHelper.UrlId.CARD_HOME)) {
            return 12;
        }
        if (TextUtils.equals(str, "small_world_distribution") && TextUtils.equals(str2, "feeds")) {
            return 13;
        }
        return i3;
    }

    public static GuildProfileData ofTextTypeData(String str, String str2, String str3, int i3) {
        GuildProfileData guildProfileData = new GuildProfileData(str, str2, str3, 0, i3);
        guildProfileData.mGuildBaseProfileData.r(str2);
        if (((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).hasDirectMsgFlag(str2) || i3 == 6) {
            guildProfileData.setDirectMessageSource(str, str2, i3);
        }
        return guildProfileData;
    }

    private void setDirectMessageSource(String str, String str2, int i3) {
        this.mExtras.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        this.mExtras.putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_GUILD_ID, str);
        this.mExtras.putString(AppConstants.Key.GUILD_DIRECT_MESSAGE_CHANNEL_ID, str2);
        long sourceGuildId = ((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).getSourceGuildId(str2);
        if (sourceGuildId != 0) {
            this.mGuildBaseProfileData.u(String.valueOf(sourceGuildId));
        }
        if (i3 == 6) {
            this.mGuildBaseProfileData.r("");
        } else {
            this.mGuildBaseProfileData.r(str2);
        }
        this.mGuildBaseProfileData.F(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDstTinyId() {
        return this.mGuildBaseProfileData.b();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public FeedImpeachData getFeedImpeachData() {
        return this.mFeedImpeachData;
    }

    public IGProUserPublishedFeedSummary getFeedSummary() {
        return this.mUserProfileInfo.r();
    }

    public GuildBaseProfileData getGuildBaseProfileData() {
        return this.mGuildBaseProfileData;
    }

    public String getGuildId() {
        return this.mGuildBaseProfileData.e();
    }

    public ev getUserProfileInfo() {
        return this.mUserProfileInfo;
    }

    public boolean isDirectMessage() {
        if (this.mExtras.getByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 0).byteValue() != 1) {
            return false;
        }
        return true;
    }

    public boolean needShowFeed() {
        boolean z16;
        ArrayList<byte[]> arrayList;
        boolean z17;
        if (this.mUserProfileInfo.getPublishedFeedShowSwitch() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        IGProUserPublishedFeedSummary r16 = this.mUserProfileInfo.r();
        if (r16 != null) {
            arrayList = r16.getFeedList();
        } else {
            arrayList = null;
        }
        if (this.mGuildBaseProfileData.g() == 6) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (arrayList != null && !arrayList.isEmpty() && !z17) {
            return true;
        }
        return false;
    }

    public void setFeedImpeachData(FeedImpeachData feedImpeachData) {
        this.mFeedImpeachData = feedImpeachData;
    }

    public void setGuildBaseProfileData(GuildBaseProfileData guildBaseProfileData) {
        this.mGuildBaseProfileData = guildBaseProfileData;
    }

    public void setUserProfileInfo(ev evVar) {
        this.mUserProfileInfo = evVar;
    }

    public String toString() {
        return "GuildProfileData{mGuildBaseProfileData=" + this.mGuildBaseProfileData + ", mUserProfileInfo=" + this.mUserProfileInfo + ", mExtras=" + this.mExtras + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.mGuildBaseProfileData, i3);
        parcel.writeBundle(this.mExtras);
    }

    protected GuildProfileData(Parcel parcel) {
        this.mExtras = new Bundle();
        this.mGuildBaseProfileData = (GuildBaseProfileData) parcel.readParcelable(GuildBaseProfileData.class.getClassLoader());
        this.mExtras = parcel.readBundle();
    }
}
