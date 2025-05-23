package com.tencent.mobileqq.sharepanel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Landroid/os/Parcelable;", "()V", "AppendAction", "Forward", "MoreFriend", "ShareChannel", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$AppendAction;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$Forward;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$MoreFriend;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$ShareChannel;", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public abstract class ShareConfirmAction implements Parcelable {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$AppendAction;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "actionId", "<init>", "(Ljava/lang/String;)V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class AppendAction extends ShareConfirmAction {
        static IPatchRedirector $redirector_;

        @NotNull
        public static final Parcelable.Creator<AppendAction> CREATOR;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String actionId;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a implements Parcelable.Creator<AppendAction> {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final AppendAction createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (AppendAction) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AppendAction(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final AppendAction[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (AppendAction[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                return new AppendAction[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41278);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AppendAction(@NotNull String actionId) {
            super(null);
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) actionId);
            } else {
                this.actionId = actionId;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.actionId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
            } else {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.actionId);
            }
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$Forward;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "getTargetList", "()Ljava/util/ArrayList;", "targetList", "<init>", "(Ljava/util/ArrayList;)V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class Forward extends ShareConfirmAction {
        static IPatchRedirector $redirector_;

        @NotNull
        public static final Parcelable.Creator<Forward> CREATOR;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<ResultRecord> targetList;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a implements Parcelable.Creator<Forward> {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Forward createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Forward) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(parcel.readParcelable(Forward.class.getClassLoader()));
                }
                return new Forward(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Forward[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Forward[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                return new Forward[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41282);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Forward(@NotNull ArrayList<ResultRecord> targetList) {
            super(null);
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) targetList);
            } else {
                this.targetList = targetList;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(parcel, "out");
            ArrayList<ResultRecord> arrayList = this.targetList;
            parcel.writeInt(arrayList.size());
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001R'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$MoreFriend;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "getSelected", "()Ljava/util/ArrayList;", "selected", "<init>", "(Ljava/util/ArrayList;)V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class MoreFriend extends ShareConfirmAction {
        static IPatchRedirector $redirector_;

        @NotNull
        public static final Parcelable.Creator<MoreFriend> CREATOR;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<ResultRecord> selected;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a implements Parcelable.Creator<MoreFriend> {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final MoreFriend createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (MoreFriend) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i3 = 0; i3 != readInt; i3++) {
                    arrayList.add(parcel.readParcelable(MoreFriend.class.getClassLoader()));
                }
                return new MoreFriend(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final MoreFriend[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (MoreFriend[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                return new MoreFriend[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41292);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MoreFriend(@NotNull ArrayList<ResultRecord> selected) {
            super(null);
            Intrinsics.checkNotNullParameter(selected, "selected");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) selected);
            } else {
                this.selected = selected;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(parcel, "out");
            ArrayList<ResultRecord> arrayList = this.selected;
            parcel.writeInt(arrayList.size());
            Iterator<ResultRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                parcel.writeParcelable(it.next(), flags);
            }
        }
    }

    /* compiled from: P */
    @Parcelize
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction$ShareChannel;", "Lcom/tencent/mobileqq/sharepanel/model/ShareConfirmAction;", "Landroid/os/Parcelable;", "", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "channelId", "<init>", "(Ljava/lang/String;)V", "qq-sharepanel-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class ShareChannel extends ShareConfirmAction {
        static IPatchRedirector $redirector_;

        @NotNull
        public static final Parcelable.Creator<ShareChannel> CREATOR;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class a implements Parcelable.Creator<ShareChannel> {
            static IPatchRedirector $redirector_;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final ShareChannel createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (ShareChannel) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new ShareChannel(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final ShareChannel[] newArray(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (ShareChannel[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
                return new ShareChannel[i3];
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41304);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 5)) {
                redirector.redirect((short) 5);
            } else {
                CREATOR = new a();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShareChannel(@NotNull String channelId) {
            super(null);
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) channelId);
            } else {
                this.channelId = channelId;
            }
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.channelId;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, flags);
            } else {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.channelId);
            }
        }
    }

    public /* synthetic */ ShareConfirmAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
    }

    ShareConfirmAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
