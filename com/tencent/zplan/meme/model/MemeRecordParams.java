package com.tencent.zplan.meme.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.zplan.meme.action.MODE;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Parcelize
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b%\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0002Z[B\u00af\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020\u0017\u0012\u0006\u0010*\u001a\u00020\u0004\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bW\u0010XJ\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0015H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0017H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u00bb\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u001c\u001a\u00020\u00042\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00062\b\b\u0002\u0010$\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\u00102\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u00042\b\b\u0002\u0010+\u001a\u00020\u00062\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010.\u001a\u00020\u0004H\u00d6\u0001J\t\u0010/\u001a\u00020\u0006H\u00d6\u0001J\u0013\u00102\u001a\u00020\u00152\b\u00101\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00103\u001a\u00020\u0006H\u00d6\u0001J\u0019\u00108\u001a\u0002072\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010\u001e\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010<\u001a\u0004\b?\u0010>R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010@\u001a\u0004\bA\u0010BR\u0019\u0010 \u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b \u0010@\u001a\u0004\bC\u0010BR\u0017\u0010!\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010<\u001a\u0004\bD\u0010>R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010<\u001a\u0004\bE\u0010>R\u0017\u0010#\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b#\u0010<\u001a\u0004\bF\u0010>R\u0017\u0010$\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b$\u0010<\u001a\u0004\bG\u0010>R\u0017\u0010%\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b%\u0010H\u001a\u0004\bI\u0010JR\u0019\u0010&\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b&\u0010K\u001a\u0004\bL\u0010MR\u0017\u0010'\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b'\u0010<\u001a\u0004\bN\u0010>R\u0017\u0010(\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b(\u0010O\u001a\u0004\b(\u0010PR\u0017\u0010)\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b)\u0010Q\u001a\u0004\bR\u0010SR\u0017\u0010*\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b*\u00109\u001a\u0004\bT\u0010;R\u0017\u0010+\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b+\u0010<\u001a\u0004\bU\u0010>R\u0019\u0010,\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b,\u00109\u001a\u0004\bV\u0010;\u00a8\u0006\\"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeRecordParams;", "Landroid/os/Parcelable;", "Lorg/json/JSONObject;", "toJSON", "", "component1", "", "component2", "component3", "Lcom/tencent/zplan/meme/model/MemeRecordParams$User;", "component4", "component5", "component6", "component7", "component8", "component9", "Lcom/tencent/zplan/meme/action/MODE;", "component10", "", "component11", "component12", "", "component13", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "component14", "component15", "component16", "component17", "uniKey", "id", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "sender", "receiver", "frameRate", "frameCount", "width", "height", "recordMode", "portraitIds", "theme", "isBatch", "businessConfig", AdMetricTag.EVENT_NAME, "actionStyle", QQBrowserActivity.APP_PARAM, "copy", "toString", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "Ljava/lang/String;", "getUniKey", "()Ljava/lang/String;", "I", "getId", "()I", "getTaskId", "Lcom/tencent/zplan/meme/model/MemeRecordParams$User;", "getSender", "()Lcom/tencent/zplan/meme/model/MemeRecordParams$User;", "getReceiver", "getFrameRate", "getFrameCount", "getWidth", "getHeight", "Lcom/tencent/zplan/meme/action/MODE;", "getRecordMode", "()Lcom/tencent/zplan/meme/action/MODE;", "[I", "getPortraitIds", "()[I", "getTheme", "Z", "()Z", "Lcom/tencent/zplan/meme/model/BusinessConfig;", "getBusinessConfig", "()Lcom/tencent/zplan/meme/model/BusinessConfig;", "getEventName", "getActionStyle", "getExtraParams", "<init>", "(Ljava/lang/String;IILcom/tencent/zplan/meme/model/MemeRecordParams$User;Lcom/tencent/zplan/meme/model/MemeRecordParams$User;IIIILcom/tencent/zplan/meme/action/MODE;[IIZLcom/tencent/zplan/meme/model/BusinessConfig;Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "User", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final /* data */ class MemeRecordParams implements Parcelable {
    public static final Parcelable.Creator<MemeRecordParams> CREATOR;

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    public static final String TAG = "MemeRecordParams";

    @Deprecated
    @NotNull
    private static final Lazy delayFrames$delegate;

    @Deprecated
    @NotNull
    private static final Lazy globalUseRecordV2Config$delegate;

    @Deprecated
    @NotNull
    private static final Lazy memeProxy$delegate;

    @Deprecated
    @NotNull
    private static final Lazy reuseRecordRuntimeData$delegate;
    private final int actionStyle;

    @NotNull
    private final BusinessConfig businessConfig;

    @NotNull
    private final String eventName;

    @Nullable
    private final String extraParams;
    private final int frameCount;
    private final int frameRate;
    private final int height;
    private final int id;
    private final boolean isBatch;

    @Nullable
    private final int[] portraitIds;

    @Nullable
    private final User receiver;

    @NotNull
    private final MODE recordMode;

    @Nullable
    private final User sender;
    private final int taskId;
    private final int theme;

    @NotNull
    private final String uniKey;
    private final int width;

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\tH\u00d6\u0001J\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tH\u00d6\u0001R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0019\u0010#\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeRecordParams$User;", "Landroid/os/Parcelable;", "", "enableDressInfo", "Lorg/json/JSONObject;", "a", "(Ljava/lang/Boolean;)Lorg/json/JSONObject;", "", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "uin", "e", "Ljava/lang/Integer;", "getGender", "()Ljava/lang/Integer;", "gender", "f", "getDressInfo", IZplanHandleApi.BUSINESS_DRESS_INFO, h.F, "getDressKey", "dressKey", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class User implements Parcelable {
        public static final Parcelable.Creator<User> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String uin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer gender;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String dressInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String dressKey;

        @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes27.dex */
        public static class a implements Parcelable.Creator<User> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final User createFromParcel(@NotNull Parcel in5) {
                Integer num;
                Intrinsics.checkNotNullParameter(in5, "in");
                String readString = in5.readString();
                if (in5.readInt() != 0) {
                    num = Integer.valueOf(in5.readInt());
                } else {
                    num = null;
                }
                return new User(readString, num, in5.readString(), in5.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final User[] newArray(int i3) {
                return new User[i3];
            }
        }

        public User() {
            this(null, null, null, null, 15, null);
        }

        @NotNull
        public final JSONObject a(@Nullable Boolean enableDressInfo) {
            boolean z16;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", this.uin);
            jSONObject.put("gender", this.gender);
            if (Intrinsics.areEqual(enableDressInfo, Boolean.TRUE)) {
                String str = this.dressInfo;
                boolean z17 = false;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(this.dressInfo);
                    String str2 = this.dressKey;
                    if (str2 == null || str2.length() == 0) {
                        z17 = true;
                    }
                    if (!z17 && b16 != null) {
                        b16.put("dress_key", this.dressKey);
                    }
                    jSONObject.put(IZplanHandleApi.BUSINESS_DRESS_INFO, b16);
                }
            }
            return jSONObject;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof User) {
                    User user = (User) other;
                    if (!Intrinsics.areEqual(this.uin, user.uin) || !Intrinsics.areEqual(this.gender, user.gender) || !Intrinsics.areEqual(this.dressInfo, user.dressInfo) || !Intrinsics.areEqual(this.dressKey, user.dressKey)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            String str = this.uin;
            int i18 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = i3 * 31;
            Integer num = this.gender;
            if (num != null) {
                i16 = num.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 31;
            String str2 = this.dressInfo;
            if (str2 != null) {
                i17 = str2.hashCode();
            } else {
                i17 = 0;
            }
            int i27 = (i26 + i17) * 31;
            String str3 = this.dressKey;
            if (str3 != null) {
                i18 = str3.hashCode();
            }
            return i27 + i18;
        }

        @NotNull
        public String toString() {
            return "User(uin=" + this.uin + ", gender=" + this.gender + ", dressInfo=" + this.dressInfo + ", dressKey=" + this.dressKey + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            int i3;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.uin);
            Integer num = this.gender;
            if (num != null) {
                parcel.writeInt(1);
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            parcel.writeString(this.dressInfo);
            parcel.writeString(this.dressKey);
        }

        public User(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
            this.uin = str;
            this.gender = num;
            this.dressInfo = str2;
            this.dressKey = str3;
        }

        public /* synthetic */ User(String str, Integer num, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/meme/model/MemeRecordParams$a;", "", "Lyx4/c;", "memeProxy$delegate", "Lkotlin/Lazy;", "c", "()Lyx4/c;", "memeProxy", "", "globalUseRecordV2Config$delegate", "b", "()Z", "globalUseRecordV2Config", "reuseRecordRuntimeData$delegate", "d", "reuseRecordRuntimeData", "", "delayFrames$delegate", "a", "()I", "delayFrames", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a {
        a() {
        }

        public final int a() {
            Lazy lazy = MemeRecordParams.delayFrames$delegate;
            a unused = MemeRecordParams.Companion;
            return ((Number) lazy.getValue()).intValue();
        }

        public final boolean b() {
            Lazy lazy = MemeRecordParams.globalUseRecordV2Config$delegate;
            a unused = MemeRecordParams.Companion;
            return ((Boolean) lazy.getValue()).booleanValue();
        }

        @NotNull
        public final yx4.c c() {
            Lazy lazy = MemeRecordParams.memeProxy$delegate;
            a unused = MemeRecordParams.Companion;
            return (yx4.c) lazy.getValue();
        }

        public final boolean d() {
            Lazy lazy = MemeRecordParams.reuseRecordRuntimeData$delegate;
            a unused = MemeRecordParams.Companion;
            return ((Boolean) lazy.getValue()).booleanValue();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static class b implements Parcelable.Creator<MemeRecordParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MemeRecordParams createFromParcel(@NotNull Parcel in5) {
            User user;
            User user2;
            boolean z16;
            Intrinsics.checkNotNullParameter(in5, "in");
            String readString = in5.readString();
            int readInt = in5.readInt();
            int readInt2 = in5.readInt();
            if (in5.readInt() != 0) {
                user = User.CREATOR.createFromParcel(in5);
            } else {
                user = null;
            }
            if (in5.readInt() != 0) {
                user2 = User.CREATOR.createFromParcel(in5);
            } else {
                user2 = null;
            }
            int readInt3 = in5.readInt();
            int readInt4 = in5.readInt();
            int readInt5 = in5.readInt();
            int readInt6 = in5.readInt();
            MODE mode = (MODE) Enum.valueOf(MODE.class, in5.readString());
            int[] createIntArray = in5.createIntArray();
            int readInt7 = in5.readInt();
            if (in5.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            return new MemeRecordParams(readString, readInt, readInt2, user, user2, readInt3, readInt4, readInt5, readInt6, mode, createIntArray, readInt7, z16, BusinessConfig.CREATOR.createFromParcel(in5), in5.readString(), in5.readInt(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MemeRecordParams[] newArray(int i3) {
            return new MemeRecordParams[i3];
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<yx4.c>() { // from class: com.tencent.zplan.meme.model.MemeRecordParams$Companion$memeProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final yx4.c invoke() {
                Object a16 = mx4.a.f417748a.a(yx4.c.class);
                Intrinsics.checkNotNull(a16);
                return (yx4.c) a16;
            }
        });
        memeProxy$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.meme.model.MemeRecordParams$Companion$globalUseRecordV2Config$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return MemeRecordParams.Companion.c().u();
            }
        });
        globalUseRecordV2Config$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.zplan.meme.model.MemeRecordParams$Companion$reuseRecordRuntimeData$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                return MemeRecordParams.Companion.c().j();
            }
        });
        reuseRecordRuntimeData$delegate = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.zplan.meme.model.MemeRecordParams$Companion$delayFrames$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return MemeRecordParams.Companion.c().l();
            }
        });
        delayFrames$delegate = lazy4;
        CREATOR = new b();
    }

    public MemeRecordParams(@NotNull String uniKey, int i3, int i16, @Nullable User user, @Nullable User user2, int i17, int i18, int i19, int i26, @NotNull MODE recordMode, @Nullable int[] iArr, int i27, boolean z16, @NotNull BusinessConfig businessConfig, @NotNull String eventName, int i28, @Nullable String str) {
        Intrinsics.checkNotNullParameter(uniKey, "uniKey");
        Intrinsics.checkNotNullParameter(recordMode, "recordMode");
        Intrinsics.checkNotNullParameter(businessConfig, "businessConfig");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.uniKey = uniKey;
        this.id = i3;
        this.taskId = i16;
        this.sender = user;
        this.receiver = user2;
        this.frameRate = i17;
        this.frameCount = i18;
        this.width = i19;
        this.height = i26;
        this.recordMode = recordMode;
        this.portraitIds = iArr;
        this.theme = i27;
        this.isBatch = z16;
        this.businessConfig = businessConfig;
        this.eventName = eventName;
        this.actionStyle = i28;
        this.extraParams = str;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getUniKey() {
        return this.uniKey;
    }

    @NotNull
    /* renamed from: component10, reason: from getter */
    public final MODE getRecordMode() {
        return this.recordMode;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final int[] getPortraitIds() {
        return this.portraitIds;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTheme() {
        return this.theme;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsBatch() {
        return this.isBatch;
    }

    @NotNull
    /* renamed from: component14, reason: from getter */
    public final BusinessConfig getBusinessConfig() {
        return this.businessConfig;
    }

    @NotNull
    /* renamed from: component15, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    /* renamed from: component16, reason: from getter */
    public final int getActionStyle() {
        return this.actionStyle;
    }

    @Nullable
    /* renamed from: component17, reason: from getter */
    public final String getExtraParams() {
        return this.extraParams;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTaskId() {
        return this.taskId;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final User getSender() {
        return this.sender;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final User getReceiver() {
        return this.receiver;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFrameRate() {
        return this.frameRate;
    }

    /* renamed from: component7, reason: from getter */
    public final int getFrameCount() {
        return this.frameCount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component9, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final MemeRecordParams copy(@NotNull String uniKey, int id5, int taskId, @Nullable User sender, @Nullable User receiver, int frameRate, int frameCount, int width, int height, @NotNull MODE recordMode, @Nullable int[] portraitIds, int theme, boolean isBatch, @NotNull BusinessConfig businessConfig, @NotNull String eventName, int actionStyle, @Nullable String extraParams) {
        Intrinsics.checkNotNullParameter(uniKey, "uniKey");
        Intrinsics.checkNotNullParameter(recordMode, "recordMode");
        Intrinsics.checkNotNullParameter(businessConfig, "businessConfig");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        return new MemeRecordParams(uniKey, id5, taskId, sender, receiver, frameRate, frameCount, width, height, recordMode, portraitIds, theme, isBatch, businessConfig, eventName, actionStyle, extraParams);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof MemeRecordParams) {
                MemeRecordParams memeRecordParams = (MemeRecordParams) other;
                if (!Intrinsics.areEqual(this.uniKey, memeRecordParams.uniKey) || this.id != memeRecordParams.id || this.taskId != memeRecordParams.taskId || !Intrinsics.areEqual(this.sender, memeRecordParams.sender) || !Intrinsics.areEqual(this.receiver, memeRecordParams.receiver) || this.frameRate != memeRecordParams.frameRate || this.frameCount != memeRecordParams.frameCount || this.width != memeRecordParams.width || this.height != memeRecordParams.height || !Intrinsics.areEqual(this.recordMode, memeRecordParams.recordMode) || !Intrinsics.areEqual(this.portraitIds, memeRecordParams.portraitIds) || this.theme != memeRecordParams.theme || this.isBatch != memeRecordParams.isBatch || !Intrinsics.areEqual(this.businessConfig, memeRecordParams.businessConfig) || !Intrinsics.areEqual(this.eventName, memeRecordParams.eventName) || this.actionStyle != memeRecordParams.actionStyle || !Intrinsics.areEqual(this.extraParams, memeRecordParams.extraParams)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int getActionStyle() {
        return this.actionStyle;
    }

    @NotNull
    public final BusinessConfig getBusinessConfig() {
        return this.businessConfig;
    }

    @NotNull
    public final String getEventName() {
        return this.eventName;
    }

    @Nullable
    public final String getExtraParams() {
        return this.extraParams;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getId() {
        return this.id;
    }

    @Nullable
    public final int[] getPortraitIds() {
        return this.portraitIds;
    }

    @Nullable
    public final User getReceiver() {
        return this.receiver;
    }

    @NotNull
    public final MODE getRecordMode() {
        return this.recordMode;
    }

    @Nullable
    public final User getSender() {
        return this.sender;
    }

    public final int getTaskId() {
        return this.taskId;
    }

    public final int getTheme() {
        return this.theme;
    }

    @NotNull
    public final String getUniKey() {
        return this.uniKey;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        String str = this.uniKey;
        int i28 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i29 = ((((i3 * 31) + this.id) * 31) + this.taskId) * 31;
        User user = this.sender;
        if (user != null) {
            i16 = user.hashCode();
        } else {
            i16 = 0;
        }
        int i36 = (i29 + i16) * 31;
        User user2 = this.receiver;
        if (user2 != null) {
            i17 = user2.hashCode();
        } else {
            i17 = 0;
        }
        int i37 = (((((((((i36 + i17) * 31) + this.frameRate) * 31) + this.frameCount) * 31) + this.width) * 31) + this.height) * 31;
        MODE mode = this.recordMode;
        if (mode != null) {
            i18 = mode.hashCode();
        } else {
            i18 = 0;
        }
        int i38 = (i37 + i18) * 31;
        int[] iArr = this.portraitIds;
        if (iArr != null) {
            i19 = Arrays.hashCode(iArr);
        } else {
            i19 = 0;
        }
        int i39 = (((i38 + i19) * 31) + this.theme) * 31;
        boolean z16 = this.isBatch;
        int i46 = z16;
        if (z16 != 0) {
            i46 = 1;
        }
        int i47 = (i39 + i46) * 31;
        BusinessConfig businessConfig = this.businessConfig;
        if (businessConfig != null) {
            i26 = businessConfig.hashCode();
        } else {
            i26 = 0;
        }
        int i48 = (i47 + i26) * 31;
        String str2 = this.eventName;
        if (str2 != null) {
            i27 = str2.hashCode();
        } else {
            i27 = 0;
        }
        int i49 = (((i48 + i27) * 31) + this.actionStyle) * 31;
        String str3 = this.extraParams;
        if (str3 != null) {
            i28 = str3.hashCode();
        }
        return i49 + i28;
    }

    public final boolean isBatch() {
        return this.isBatch;
    }

    @NotNull
    public final JSONObject toJSON() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, this.taskId);
        jSONObject.put("frameRate", this.frameRate);
        jSONObject.put("frameCount", this.frameCount);
        jSONObject.put("width", this.width);
        jSONObject.put("height", this.height);
        jSONObject.put("_uniKey_", this.uniKey);
        if (this.businessConfig.getActionStyle() != -1) {
            jSONObject.put("bodyType", this.businessConfig.getActionStyle());
        }
        int[] iArr = this.portraitIds;
        if (iArr != null) {
            jSONObject.put("portraitIds", new JSONArray(iArr));
        }
        jSONObject.put("theme", this.theme);
        jSONObject.put("isBatch", this.isBatch);
        int backgroundColor = this.businessConfig.getBackgroundColor();
        boolean z16 = false;
        if (backgroundColor == 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        jSONObject.put("opacityBackground", i3);
        jSONObject.put("backgroundColor", backgroundColor);
        User user = this.sender;
        if (user != null) {
            jSONObject.put("sender", user.a(this.businessConfig.getEnableUserData()));
        }
        User user2 = this.receiver;
        if (user2 != null) {
            jSONObject.put("receiver", user2.a(this.businessConfig.getEnableUserData()));
        }
        JSONObject f16 = this.businessConfig.getCamera().f();
        if (f16 != null) {
            jSONObject.put("camera", f16);
        }
        Integer aaType = this.businessConfig.getAaType();
        if (aaType != null) {
            jSONObject.put("AAType", aaType.intValue());
        }
        Integer aaLevel = this.businessConfig.getAaLevel();
        if (aaLevel != null) {
            jSONObject.put("AALevel", aaLevel.intValue());
        }
        Boolean skipHotPatch = this.businessConfig.getSkipHotPatch();
        if (skipHotPatch != null) {
            jSONObject.put("SkipHotPatch", wx4.d.INSTANCE.b(skipHotPatch.booleanValue()));
        }
        a aVar = Companion;
        if (aVar.b() && this.businessConfig.getUseRecordV2()) {
            jSONObject.put("useRecordV2", 1);
            if (aVar.d()) {
                jSONObject.put("reuseRuntimeData", 1);
            }
        }
        String stickerData = this.businessConfig.getStickerData();
        if (stickerData.length() > 0) {
            z16 = true;
        }
        if (z16) {
            jSONObject.put("stickerData", com.tencent.zplan.common.utils.h.f385294a.b(stickerData));
        }
        if (!this.isBatch) {
            jSONObject.put("delayFrames", aVar.a());
        }
        Boolean disableGlassesMetallic = this.businessConfig.getDisableGlassesMetallic();
        if (disableGlassesMetallic != null) {
            jSONObject.put("disableGlassesMetallic", disableGlassesMetallic.booleanValue());
        }
        String str = this.extraParams;
        if (str != null) {
            jSONObject.put(QQBrowserActivity.APP_PARAM, str);
        }
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "MemeRecordParams(uniKey=" + this.uniKey + ", id=" + this.id + ", taskId=" + this.taskId + ", sender=" + this.sender + ", receiver=" + this.receiver + ", frameRate=" + this.frameRate + ", frameCount=" + this.frameCount + ", width=" + this.width + ", height=" + this.height + ", recordMode=" + this.recordMode + ", portraitIds=" + Arrays.toString(this.portraitIds) + ", theme=" + this.theme + ", isBatch=" + this.isBatch + ", businessConfig=" + this.businessConfig + ", eventName=" + this.eventName + ", actionStyle=" + this.actionStyle + ", extraParams=" + this.extraParams + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.uniKey);
        parcel.writeInt(this.id);
        parcel.writeInt(this.taskId);
        User user = this.sender;
        if (user != null) {
            parcel.writeInt(1);
            user.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        User user2 = this.receiver;
        if (user2 != null) {
            parcel.writeInt(1);
            user2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.frameRate);
        parcel.writeInt(this.frameCount);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.recordMode.name());
        parcel.writeIntArray(this.portraitIds);
        parcel.writeInt(this.theme);
        parcel.writeInt(this.isBatch ? 1 : 0);
        this.businessConfig.writeToParcel(parcel, 0);
        parcel.writeString(this.eventName);
        parcel.writeInt(this.actionStyle);
        parcel.writeString(this.extraParams);
    }

    public /* synthetic */ MemeRecordParams(String str, int i3, int i16, User user, User user2, int i17, int i18, int i19, int i26, MODE mode, int[] iArr, int i27, boolean z16, BusinessConfig businessConfig, String str2, int i28, String str3, int i29, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i29 & 2) != 0 ? 0 : i3, (i29 & 4) != 0 ? 0 : i16, user, (i29 & 16) != 0 ? null : user2, (i29 & 32) != 0 ? 0 : i17, (i29 & 64) != 0 ? 0 : i18, (i29 & 128) != 0 ? 0 : i19, (i29 & 256) != 0 ? 0 : i26, mode, (i29 & 1024) != 0 ? null : iArr, (i29 & 2048) != 0 ? 0 : i27, (i29 & 4096) != 0 ? false : z16, businessConfig, str2, (32768 & i29) != 0 ? -1 : i28, (i29 & 65536) != 0 ? null : str3);
    }
}
