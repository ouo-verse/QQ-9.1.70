package com.tenpay.payment;

import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.tencent.ams.mosaic.jsengine.animation.IAnimationFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J,\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fH\u0002J$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/payment/ChooseFriendsParser;", "", "()V", "KEY_CHOOSE_FRIEND_GROUP_COUNTS", "", "KEY_CHOOSE_FRIEND_GROUP_NAMES", "KEY_CHOOSE_FRIEND_GROUP_TYPES", "KEY_CHOOSE_FRIEND_GROUP_UINS", "KEY_CHOOSE_FRIEND_NAMES", "KEY_CHOOSE_FRIEND_PHONES", "KEY_CHOOSE_FRIEND_UINS", "parseFriends", "", "Lcom/tenpay/payment/ChooseFriendsParser$Friend;", "resultData", "Landroid/os/Bundle;", "parseGroups", "Lcom/tenpay/payment/ChooseFriendsParser$Group;", "supportGroupType", "", "parseResult", "Lcom/tenpay/payment/ChooseFriendsParser$ChooseFriendResult;", "ChooseFriendResult", "Friend", IAnimationFactory.AnimationType.f70702GROUP, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class ChooseFriendsParser {

    @NotNull
    public static final ChooseFriendsParser INSTANCE = new ChooseFriendsParser();

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_GROUP_COUNTS = "choose_friend_group_counts";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_GROUP_NAMES = "choose_friend_group_names";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_GROUP_TYPES = "choose_friend_group_types";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_GROUP_UINS = "choose_friend_group_uins";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_NAMES = "choose_friend_names";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_PHONES = "choose_friend_phones";

    @NotNull
    private static final String KEY_CHOOSE_FRIEND_UINS = "choose_friend_uins";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/payment/ChooseFriendsParser$ChooseFriendResult;", "", "friends", "", "Lcom/tenpay/payment/ChooseFriendsParser$Friend;", "groups", "Lcom/tenpay/payment/ChooseFriendsParser$Group;", "(Ljava/util/List;Ljava/util/List;)V", "getFriends", "()Ljava/util/List;", "getGroups", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class ChooseFriendResult {

        @Nullable
        private final List<Friend> friends;

        @Nullable
        private final List<Group> groups;

        public ChooseFriendResult(@Nullable List<Friend> list, @Nullable List<Group> list2) {
            this.friends = list;
            this.groups = list2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChooseFriendResult copy$default(ChooseFriendResult chooseFriendResult, List list, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = chooseFriendResult.friends;
            }
            if ((i3 & 2) != 0) {
                list2 = chooseFriendResult.groups;
            }
            return chooseFriendResult.copy(list, list2);
        }

        @Nullable
        public final List<Friend> component1() {
            return this.friends;
        }

        @Nullable
        public final List<Group> component2() {
            return this.groups;
        }

        @NotNull
        public final ChooseFriendResult copy(@Nullable List<Friend> friends, @Nullable List<Group> groups) {
            return new ChooseFriendResult(friends, groups);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChooseFriendResult)) {
                return false;
            }
            ChooseFriendResult chooseFriendResult = (ChooseFriendResult) other;
            if (Intrinsics.areEqual(this.friends, chooseFriendResult.friends) && Intrinsics.areEqual(this.groups, chooseFriendResult.groups)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final List<Friend> getFriends() {
            return this.friends;
        }

        @Nullable
        public final List<Group> getGroups() {
            return this.groups;
        }

        public int hashCode() {
            int hashCode;
            List<Friend> list = this.friends;
            int i3 = 0;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            int i16 = hashCode * 31;
            List<Group> list2 = this.groups;
            if (list2 != null) {
                i3 = list2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "ChooseFriendResult(friends=" + this.friends + ", groups=" + this.groups + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0007H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/payment/ChooseFriendsParser$Friend;", "", "uin", "", "phone", "name", "type", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getName", "()Ljava/lang/String;", "getPhone", "getType", "()I", "getUin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Friend {

        @SerializedName("name")
        @NotNull
        private final String name;

        @SerializedName("phone")
        @NotNull
        private final String phone;

        @SerializedName("type")
        private final int type;

        @SerializedName("uin")
        @NotNull
        private final String uin;

        public Friend(@NotNull String uin, @NotNull String phone, @NotNull String name, int i3) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(name, "name");
            this.uin = uin;
            this.phone = phone;
            this.name = name;
            this.type = i3;
        }

        public static /* synthetic */ Friend copy$default(Friend friend, String str, String str2, String str3, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = friend.uin;
            }
            if ((i16 & 2) != 0) {
                str2 = friend.phone;
            }
            if ((i16 & 4) != 0) {
                str3 = friend.name;
            }
            if ((i16 & 8) != 0) {
                i3 = friend.type;
            }
            return friend.copy(str, str2, str3, i3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component4, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        public final Friend copy(@NotNull String uin, @NotNull String phone, @NotNull String name, int type) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(name, "name");
            return new Friend(uin, phone, name, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Friend)) {
                return false;
            }
            Friend friend = (Friend) other;
            if (Intrinsics.areEqual(this.uin, friend.uin) && Intrinsics.areEqual(this.phone, friend.phone) && Intrinsics.areEqual(this.name, friend.name) && this.type == friend.type) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getPhone() {
            return this.phone;
        }

        public final int getType() {
            return this.type;
        }

        @NotNull
        public final String getUin() {
            return this.uin;
        }

        public int hashCode() {
            return (((((this.uin.hashCode() * 31) + this.phone.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type;
        }

        @NotNull
        public String toString() {
            return "Friend(uin=" + this.uin + ", phone=" + this.phone + ", name=" + this.name + ", type=" + this.type + ")";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/tenpay/payment/ChooseFriendsParser$Group;", "", "uin", "", "name", "type", "", "count", "(Ljava/lang/String;Ljava/lang/String;II)V", "getCount", "()I", "getName", "()Ljava/lang/String;", "getType", "getUin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Group {

        @SerializedName("count")
        private final int count;

        @SerializedName("name")
        @NotNull
        private final String name;

        @SerializedName("type")
        private final int type;

        @SerializedName("uin")
        @NotNull
        private final String uin;

        public Group(@NotNull String uin, @NotNull String name, int i3, int i16) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(name, "name");
            this.uin = uin;
            this.name = name;
            this.type = i3;
            this.count = i16;
        }

        public static /* synthetic */ Group copy$default(Group group, String str, String str2, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                str = group.uin;
            }
            if ((i17 & 2) != 0) {
                str2 = group.name;
            }
            if ((i17 & 4) != 0) {
                i3 = group.type;
            }
            if ((i17 & 8) != 0) {
                i16 = group.count;
            }
            return group.copy(str, str2, i3, i16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* renamed from: component4, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final Group copy(@NotNull String uin, @NotNull String name, int type, int count) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(name, "name");
            return new Group(uin, name, type, count);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Group)) {
                return false;
            }
            Group group = (Group) other;
            if (Intrinsics.areEqual(this.uin, group.uin) && Intrinsics.areEqual(this.name, group.name) && this.type == group.type && this.count == group.count) {
                return true;
            }
            return false;
        }

        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final int getType() {
            return this.type;
        }

        @NotNull
        public final String getUin() {
            return this.uin;
        }

        public int hashCode() {
            return (((((this.uin.hashCode() * 31) + this.name.hashCode()) * 31) + this.type) * 31) + this.count;
        }

        @NotNull
        public String toString() {
            return "Group(uin=" + this.uin + ", name=" + this.name + ", type=" + this.type + ", count=" + this.count + ")";
        }
    }

    ChooseFriendsParser() {
    }

    private final List<Friend> parseFriends(Bundle resultData) {
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        if (resultData == null || (stringArrayList = resultData.getStringArrayList(KEY_CHOOSE_FRIEND_UINS)) == null || (stringArrayList2 = resultData.getStringArrayList(KEY_CHOOSE_FRIEND_PHONES)) == null || (stringArrayList3 = resultData.getStringArrayList(KEY_CHOOSE_FRIEND_NAMES)) == null) {
            return null;
        }
        int min = Math.min(stringArrayList.size(), Math.min(stringArrayList2.size(), stringArrayList3.size()));
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < min; i3++) {
            String str = stringArrayList.get(i3);
            String str2 = "";
            if (str == null) {
                str = "";
            }
            String str3 = stringArrayList2.get(i3);
            if (str3 == null) {
                str3 = "";
            }
            String str4 = stringArrayList3.get(i3);
            if (str4 != null) {
                str2 = str4;
            }
            arrayList.add(new Friend(str, str3, str2, 1));
        }
        return arrayList;
    }

    private final List<Group> parseGroups(Bundle resultData, List<Integer> supportGroupType) {
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<Integer> integerArrayList;
        ArrayList<Integer> integerArrayList2;
        int minOf;
        if (resultData == null || (stringArrayList = resultData.getStringArrayList(KEY_CHOOSE_FRIEND_GROUP_UINS)) == null || (stringArrayList2 = resultData.getStringArrayList(KEY_CHOOSE_FRIEND_GROUP_NAMES)) == null || (integerArrayList = resultData.getIntegerArrayList(KEY_CHOOSE_FRIEND_GROUP_COUNTS)) == null || (integerArrayList2 = resultData.getIntegerArrayList(KEY_CHOOSE_FRIEND_GROUP_TYPES)) == null) {
            return null;
        }
        minOf = ComparisonsKt___ComparisonsJvmKt.minOf(stringArrayList.size(), stringArrayList2.size(), integerArrayList.size(), integerArrayList2.size());
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < minOf; i3++) {
            Integer num = integerArrayList2.get(i3);
            Intrinsics.checkNotNullExpressionValue(num, "groupTypes[index]");
            int intValue = num.intValue();
            if (supportGroupType == null || supportGroupType.contains(Integer.valueOf(intValue))) {
                String str = stringArrayList.get(i3);
                String str2 = "";
                if (str == null) {
                    str = "";
                }
                String str3 = stringArrayList2.get(i3);
                if (str3 != null) {
                    str2 = str3;
                }
                Integer num2 = integerArrayList2.get(i3);
                Intrinsics.checkNotNullExpressionValue(num2, "groupTypes[index]");
                int intValue2 = num2.intValue();
                Integer num3 = integerArrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(num3, "groupCounts[index]");
                arrayList.add(new Group(str, str2, intValue2, num3.intValue()));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List parseGroups$default(ChooseFriendsParser chooseFriendsParser, Bundle bundle, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        return chooseFriendsParser.parseGroups(bundle, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChooseFriendResult parseResult$default(ChooseFriendsParser chooseFriendsParser, Bundle bundle, List list, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            list = null;
        }
        return chooseFriendsParser.parseResult(bundle, list);
    }

    @Nullable
    public final ChooseFriendResult parseResult(@Nullable Bundle resultData, @Nullable List<Integer> supportGroupType) {
        if (resultData == null) {
            return null;
        }
        return new ChooseFriendResult(parseFriends(resultData), parseGroups(resultData, supportGroupType));
    }
}
