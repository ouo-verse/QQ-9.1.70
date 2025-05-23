package com.tenpay.pay.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tenpay.pay.FriendPayController;
import com.tenpay.pay.PayChannelUtils;
import com.tenpay.sdk.util.QWSoterConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB)\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010\u0082\u0001\b !\"#$%&'\u00a8\u0006("}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean;", "", NodeProps.VISIBLE, "", "isCheck", "bgRadiusEnum", "Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "sortPriority", "", "(ZZLcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;I)V", "getBgRadiusEnum", "()Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;", "setBgRadiusEnum", "(Lcom/tenpay/pay/PayChannelUtils$BgRadiusEnum;)V", "()Z", "setCheck", "(Z)V", "getSortPriority", "()I", "setSortPriority", "(I)V", "getVisible", "setVisible", "AddMore", "AutoPayCard", "Balance", "Bank", "FriendPay", "MiniApp", "More", "QQHeader", "Wx", "Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "Lcom/tenpay/pay/model/PayChannelBean$Balance;", "Lcom/tenpay/pay/model/PayChannelBean$Bank;", "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "Lcom/tenpay/pay/model/PayChannelBean$More;", "Lcom/tenpay/pay/model/PayChannelBean$QQHeader;", "Lcom/tenpay/pay/model/PayChannelBean$Wx;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public abstract class PayChannelBean {

    @NotNull
    private PayChannelUtils.BgRadiusEnum bgRadiusEnum;
    private boolean isCheck;
    private int sortPriority;
    private boolean visible;

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003JP\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010&J\t\u0010'\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010*H\u00d6\u0003J\t\u0010+\u001a\u00020\u0004H\u00d6\u0001J\t\u0010,\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001b\u00a8\u00063"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "logoResId", "", "title", "", "tokenId", "passFlag", "payScene", "disable", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "getDisable", "()Z", "setDisable", "(Z)V", "getLogoResId", "()I", "getPassFlag", "()Ljava/lang/Integer;", "setPassFlag", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPayScene", "()Ljava/lang/String;", "setPayScene", "(Ljava/lang/String;)V", "getTitle", "getTokenId", "setTokenId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class AddMore extends PayChannelBean implements Parcelable {
        private boolean disable;
        private final int logoResId;

        @Nullable
        private Integer passFlag;

        @Nullable
        private String payScene;

        @NotNull
        private final String title;

        @Nullable
        private String tokenId;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<AddMore> CREATOR = new Creator();

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$AddMore$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/pay/model/PayChannelBean$AddMore;", "qpayGateJSON", "Lorg/json/JSONObject;", "logoResId", "", "title", "", "tokenId", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @NotNull
            public final AddMore create(@NotNull JSONObject qpayGateJSON, int i3, @NotNull String title, @Nullable String str) {
                Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
                Intrinsics.checkNotNullParameter(title, "title");
                AddMore addMore = new AddMore(i3, title, null, null, null, false, 60, null);
                addMore.setTokenId(str);
                boolean z16 = false;
                addMore.setPassFlag(Integer.valueOf(qpayGateJSON.optInt("pass_flag", 0)));
                addMore.setPayScene(qpayGateJSON.optString("pay_scene"));
                if ((qpayGateJSON.optInt("pay_types", 63) & 32) == 0) {
                    z16 = true;
                }
                addMore.setDisable(z16);
                return addMore;
            }

            Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<AddMore> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AddMore createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AddMore(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AddMore[] newArray(int i3) {
                return new AddMore[i3];
            }
        }

        public /* synthetic */ AddMore(int i3, String str, String str2, Integer num, String str3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : num, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? false : z16);
        }

        public static /* synthetic */ AddMore copy$default(AddMore addMore, int i3, String str, String str2, Integer num, String str3, boolean z16, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = addMore.logoResId;
            }
            if ((i16 & 2) != 0) {
                str = addMore.title;
            }
            String str4 = str;
            if ((i16 & 4) != 0) {
                str2 = addMore.tokenId;
            }
            String str5 = str2;
            if ((i16 & 8) != 0) {
                num = addMore.passFlag;
            }
            Integer num2 = num;
            if ((i16 & 16) != 0) {
                str3 = addMore.payScene;
            }
            String str6 = str3;
            if ((i16 & 32) != 0) {
                z16 = addMore.disable;
            }
            return addMore.copy(i3, str4, str5, num2, str6, z16);
        }

        @JvmStatic
        @NotNull
        public static final AddMore create(@NotNull JSONObject jSONObject, int i3, @NotNull String str, @Nullable String str2) {
            return INSTANCE.create(jSONObject, i3, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLogoResId() {
            return this.logoResId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getTokenId() {
            return this.tokenId;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Integer getPassFlag() {
            return this.passFlag;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getPayScene() {
            return this.payScene;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getDisable() {
            return this.disable;
        }

        @NotNull
        public final AddMore copy(int logoResId, @NotNull String title, @Nullable String tokenId, @Nullable Integer passFlag, @Nullable String payScene, boolean disable) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new AddMore(logoResId, title, tokenId, passFlag, payScene, disable);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddMore)) {
                return false;
            }
            AddMore addMore = (AddMore) other;
            if (this.logoResId == addMore.logoResId && Intrinsics.areEqual(this.title, addMore.title) && Intrinsics.areEqual(this.tokenId, addMore.tokenId) && Intrinsics.areEqual(this.passFlag, addMore.passFlag) && Intrinsics.areEqual(this.payScene, addMore.payScene) && this.disable == addMore.disable) {
                return true;
            }
            return false;
        }

        public final boolean getDisable() {
            return this.disable;
        }

        public final int getLogoResId() {
            return this.logoResId;
        }

        @Nullable
        public final Integer getPassFlag() {
            return this.passFlag;
        }

        @Nullable
        public final String getPayScene() {
            return this.payScene;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTokenId() {
            return this.tokenId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3 = ((this.logoResId * 31) + this.title.hashCode()) * 31;
            String str = this.tokenId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode3 + hashCode) * 31;
            Integer num = this.passFlag;
            if (num == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str2 = this.payScene;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            int i18 = (i17 + i3) * 31;
            boolean z16 = this.disable;
            int i19 = z16;
            if (z16 != 0) {
                i19 = 1;
            }
            return i18 + i19;
        }

        public final void setDisable(boolean z16) {
            this.disable = z16;
        }

        public final void setPassFlag(@Nullable Integer num) {
            this.passFlag = num;
        }

        public final void setPayScene(@Nullable String str) {
            this.payScene = str;
        }

        public final void setTokenId(@Nullable String str) {
            this.tokenId = str;
        }

        @NotNull
        public String toString() {
            return "AddMore(logoResId=" + this.logoResId + ", title=" + this.title + ", tokenId=" + this.tokenId + ", passFlag=" + this.passFlag + ", payScene=" + this.payScene + ", disable=" + this.disable + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r36) {
            int intValue;
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.logoResId);
            parcel.writeString(this.title);
            parcel.writeString(this.tokenId);
            Integer num = this.passFlag;
            if (num == null) {
                intValue = 0;
            } else {
                parcel.writeInt(1);
                intValue = num.intValue();
            }
            parcel.writeInt(intValue);
            parcel.writeString(this.payScene);
            parcel.writeInt(this.disable ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMore(int i3, @NotNull String title, @Nullable String str, @Nullable Integer num, @Nullable String str2, boolean z16) {
            super(false, false, PayChannelUtils.BgRadiusEnum.BottomRound, 0, 8, null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.logoResId = i3;
            this.title = title;
            this.tokenId = str;
            this.passFlag = num;
            this.payScene = str2;
            this.disable = z16;
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017Bi\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010!\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0086\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001\u00a2\u0006\u0002\u0010*J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u00d6\u0003J\t\u00100\u001a\u00020\u0007H\u00d6\u0001J\t\u00101\u001a\u00020\u0004H\u00d6\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0007H\u00d6\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011\u00a8\u00068"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "busiName", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "disable", "", "logoId", "spfaBalance", "disableComment", "disableUrl", "disableBrief", "uin", "indexInJSON", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBusiName", "()Ljava/lang/String;", "getBusiType", "getDisable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisableBrief", "getDisableComment", "getDisableUrl", "getIndexInJSON", "setIndexInJSON", "(Ljava/lang/Integer;)V", "getLogoId", "getSpfaBalance", "getUin", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class AutoPayCard extends PayChannelBean implements Parcelable {

        @SerializedName("busi_name")
        @Nullable
        private final String busiName;

        @SerializedName(QWSoterConstans.CGI_KEY_BUSI_TYPE)
        @Nullable
        private final String busiType;

        @SerializedName("disable")
        @Nullable
        private final Integer disable;

        @SerializedName("disable_title")
        @Nullable
        private final String disableBrief;

        @SerializedName("disable_comment")
        @Nullable
        private final String disableComment;

        @SerializedName("disable_url")
        @Nullable
        private final String disableUrl;

        @Nullable
        private Integer indexInJSON;

        @SerializedName("image_id")
        @Nullable
        private final String logoId;

        @SerializedName("spfa_balance")
        @Nullable
        private final String spfaBalance;

        @Nullable
        private final String uin;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<AutoPayCard> CREATOR = new Creator();

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard$Companion;", "", "()V", "createList", "", "Lcom/tenpay/pay/model/PayChannelBean$AutoPayCard;", "qpayGateJSON", "Lorg/json/JSONObject;", "inGson", "Lcom/google/gson/Gson;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ List createList$default(Companion companion, JSONObject jSONObject, Gson gson, int i3, Object obj) {
                if ((i3 & 2) != 0) {
                    gson = null;
                }
                return companion.createList(jSONObject, gson);
            }

            @NotNull
            public final List<AutoPayCard> createList(@NotNull JSONObject qpayGateJSON, @Nullable Gson inGson) {
                Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
                if (inGson == null) {
                    inGson = new GsonBuilder().create();
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = qpayGateJSON.optJSONArray("spfa_info");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        AutoPayCard bankChannel = (AutoPayCard) inGson.fromJson(optJSONArray.get(i3).toString(), AutoPayCard.class);
                        bankChannel.setIndexInJSON(Integer.valueOf(i3));
                        Intrinsics.checkNotNullExpressionValue(bankChannel, "bankChannel");
                        arrayList.add(bankChannel);
                    }
                }
                return arrayList;
            }

            Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<AutoPayCard> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPayCard createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AutoPayCard(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final AutoPayCard[] newArray(int i3) {
                return new AutoPayCard[i3];
            }
        }

        public AutoPayCard(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Integer num2) {
            super(false, false, PayChannelUtils.BgRadiusEnum.BottomRound, 0, 8, null);
            this.busiName = str;
            this.busiType = str2;
            this.disable = num;
            this.logoId = str3;
            this.spfaBalance = str4;
            this.disableComment = str5;
            this.disableUrl = str6;
            this.disableBrief = str7;
            this.uin = str8;
            this.indexInJSON = num2;
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getBusiName() {
            return this.busiName;
        }

        @Nullable
        /* renamed from: component10, reason: from getter */
        public final Integer getIndexInJSON() {
            return this.indexInJSON;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getBusiType() {
            return this.busiType;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getSpfaBalance() {
            return this.spfaBalance;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @NotNull
        public final AutoPayCard copy(@Nullable String busiName, @Nullable String r142, @Nullable Integer disable, @Nullable String logoId, @Nullable String spfaBalance, @Nullable String disableComment, @Nullable String disableUrl, @Nullable String disableBrief, @Nullable String uin, @Nullable Integer indexInJSON) {
            return new AutoPayCard(busiName, r142, disable, logoId, spfaBalance, disableComment, disableUrl, disableBrief, uin, indexInJSON);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AutoPayCard)) {
                return false;
            }
            AutoPayCard autoPayCard = (AutoPayCard) other;
            if (Intrinsics.areEqual(this.busiName, autoPayCard.busiName) && Intrinsics.areEqual(this.busiType, autoPayCard.busiType) && Intrinsics.areEqual(this.disable, autoPayCard.disable) && Intrinsics.areEqual(this.logoId, autoPayCard.logoId) && Intrinsics.areEqual(this.spfaBalance, autoPayCard.spfaBalance) && Intrinsics.areEqual(this.disableComment, autoPayCard.disableComment) && Intrinsics.areEqual(this.disableUrl, autoPayCard.disableUrl) && Intrinsics.areEqual(this.disableBrief, autoPayCard.disableBrief) && Intrinsics.areEqual(this.uin, autoPayCard.uin) && Intrinsics.areEqual(this.indexInJSON, autoPayCard.indexInJSON)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getBusiName() {
            return this.busiName;
        }

        @Nullable
        public final String getBusiType() {
            return this.busiType;
        }

        @Nullable
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @Nullable
        public final Integer getIndexInJSON() {
            return this.indexInJSON;
        }

        @Nullable
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        public final String getSpfaBalance() {
            return this.spfaBalance;
        }

        @Nullable
        public final String getUin() {
            return this.uin;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            int hashCode9;
            String str = this.busiName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.busiType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Integer num = this.disable;
            if (num == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = num.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str3 = this.logoId;
            if (str3 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str3.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str4 = this.spfaBalance;
            if (str4 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str4.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str5 = this.disableComment;
            if (str5 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str5.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str6 = this.disableUrl;
            if (str6 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str6.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            String str7 = this.disableBrief;
            if (str7 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str7.hashCode();
            }
            int i29 = (i28 + hashCode8) * 31;
            String str8 = this.uin;
            if (str8 == null) {
                hashCode9 = 0;
            } else {
                hashCode9 = str8.hashCode();
            }
            int i36 = (i29 + hashCode9) * 31;
            Integer num2 = this.indexInJSON;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return i36 + i3;
        }

        public final void setIndexInJSON(@Nullable Integer num) {
            this.indexInJSON = num;
        }

        @NotNull
        public String toString() {
            return "AutoPayCard(busiName=" + this.busiName + ", busiType=" + this.busiType + ", disable=" + this.disable + ", logoId=" + this.logoId + ", spfaBalance=" + this.spfaBalance + ", disableComment=" + this.disableComment + ", disableUrl=" + this.disableUrl + ", disableBrief=" + this.disableBrief + ", uin=" + this.uin + ", indexInJSON=" + this.indexInJSON + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r46) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.busiName);
            parcel.writeString(this.busiType);
            Integer num = this.disable;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.logoId);
            parcel.writeString(this.spfaBalance);
            parcel.writeString(this.disableComment);
            parcel.writeString(this.disableUrl);
            parcel.writeString(this.disableBrief);
            parcel.writeString(this.uin);
            Integer num2 = this.indexInJSON;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B_\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010)\u001a\u00020\u0007J\u0010\u0010*\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010+\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010-\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0010\u0010.\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0018J\u000b\u0010/\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003Jz\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001\u00a2\u0006\u0002\u00104J\t\u00105\u001a\u00020\nH\u00d6\u0001J\u0013\u00106\u001a\u00020\u00072\b\u00107\u001a\u0004\u0018\u000108H\u00d6\u0003J\t\u00109\u001a\u00020\nH\u00d6\u0001J\t\u0010:\u001a\u00020\fH\u00d6\u0001J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\nH\u00d6\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015\u00a8\u0006A"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$Balance;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "balance", "", "totalFee", "supportBalance", "", "hasRealName", "disable", "", "disableComment", "", "disableUrl", "disableBrief", "miniApp", "Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tenpay/pay/model/PayChannelBean$MiniApp;)V", "getBalance", "()Ljava/lang/Long;", "setBalance", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDisable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisableBrief", "()Ljava/lang/String;", "getDisableComment", "getDisableUrl", "getHasRealName", "()Ljava/lang/Boolean;", "setHasRealName", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getMiniApp", "()Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "getSupportBalance", "setSupportBalance", "getTotalFee", "setTotalFee", "canUse", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tenpay/pay/model/PayChannelBean$MiniApp;)Lcom/tenpay/pay/model/PayChannelBean$Balance;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Balance extends PayChannelBean implements Parcelable {

        @Nullable
        private Long balance;

        @SerializedName("disable")
        @Nullable
        private final Integer disable;

        @SerializedName("disable_title")
        @Nullable
        private final String disableBrief;

        @SerializedName("disable_comment")
        @Nullable
        private final String disableComment;

        @SerializedName("disable_url")
        @Nullable
        private final String disableUrl;

        @Nullable
        private Boolean hasRealName;

        @SerializedName("miniapp")
        @Nullable
        private final MiniApp miniApp;

        @Nullable
        private Boolean supportBalance;

        @Nullable
        private Long totalFee;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<Balance> CREATOR = new Creator();

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$Balance$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/pay/model/PayChannelBean$Balance;", "qpayGateJSON", "Lorg/json/JSONObject;", "gsonInstance", "Lcom/google/gson/Gson;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ Balance create$default(Companion companion, JSONObject jSONObject, Gson gson, int i3, Object obj) {
                if ((i3 & 2) != 0) {
                    gson = null;
                }
                return companion.create(jSONObject, gson);
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x0064  */
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Balance create(@NotNull JSONObject qpayGateJSON, @Nullable Gson gson) {
                boolean z16;
                boolean z17;
                Gson create;
                Balance balance;
                Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
                long optLong = qpayGateJSON.optLong("balance");
                long optLong2 = qpayGateJSON.optLong("total_fee");
                if ((qpayGateJSON.optInt("pay_types", 63) & 1) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (qpayGateJSON.optInt("user_attr") != 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (gson == null) {
                    try {
                        create = new GsonBuilder().create();
                    } catch (Exception e16) {
                        QLog.w("PayChannelBean.Balance", 1, "create Balance fail: ", e16);
                    }
                } else {
                    create = gson;
                }
                JSONObject optJSONObject = qpayGateJSON.optJSONObject("balance_info");
                if (optJSONObject != null) {
                    balance = (Balance) create.fromJson(optJSONObject.toString(), Balance.class);
                    if (balance == null) {
                        balance = new Balance(Long.valueOf(optLong), Long.valueOf(optLong2), Boolean.valueOf(z16), Boolean.FALSE, 0, null, null, null, null);
                    }
                    balance.setBalance(Long.valueOf(optLong));
                    balance.setTotalFee(Long.valueOf(optLong2));
                    balance.setSupportBalance(Boolean.valueOf(z16));
                    balance.setHasRealName(Boolean.valueOf(z17));
                    return balance;
                }
                balance = null;
                if (balance == null) {
                }
                balance.setBalance(Long.valueOf(optLong));
                balance.setTotalFee(Long.valueOf(optLong2));
                balance.setSupportBalance(Boolean.valueOf(z16));
                balance.setHasRealName(Boolean.valueOf(z17));
                return balance;
            }

            Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<Balance> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Balance createFromParcel(@NotNull Parcel parcel) {
                Boolean valueOf;
                Boolean valueOf2;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Long valueOf3 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
                Long valueOf4 = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
                if (parcel.readInt() == 0) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(parcel.readInt() != 0);
                }
                if (parcel.readInt() == 0) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new Balance(valueOf3, valueOf4, valueOf, valueOf2, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? MiniApp.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Balance[] newArray(int i3) {
                return new Balance[i3];
            }
        }

        public Balance(@Nullable Long l3, @Nullable Long l16, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable MiniApp miniApp) {
            super(true, true, PayChannelUtils.BgRadiusEnum.NONE, 0, 8, null);
            this.balance = l3;
            this.totalFee = l16;
            this.supportBalance = bool;
            this.hasRealName = bool2;
            this.disable = num;
            this.disableComment = str;
            this.disableUrl = str2;
            this.disableBrief = str3;
            this.miniApp = miniApp;
        }

        public static /* synthetic */ Balance copy$default(Balance balance, Long l3, Long l16, Boolean bool, Boolean bool2, Integer num, String str, String str2, String str3, MiniApp miniApp, int i3, Object obj) {
            Long l17;
            Long l18;
            Boolean bool3;
            Boolean bool4;
            Integer num2;
            String str4;
            String str5;
            String str6;
            MiniApp miniApp2;
            if ((i3 & 1) != 0) {
                l17 = balance.balance;
            } else {
                l17 = l3;
            }
            if ((i3 & 2) != 0) {
                l18 = balance.totalFee;
            } else {
                l18 = l16;
            }
            if ((i3 & 4) != 0) {
                bool3 = balance.supportBalance;
            } else {
                bool3 = bool;
            }
            if ((i3 & 8) != 0) {
                bool4 = balance.hasRealName;
            } else {
                bool4 = bool2;
            }
            if ((i3 & 16) != 0) {
                num2 = balance.disable;
            } else {
                num2 = num;
            }
            if ((i3 & 32) != 0) {
                str4 = balance.disableComment;
            } else {
                str4 = str;
            }
            if ((i3 & 64) != 0) {
                str5 = balance.disableUrl;
            } else {
                str5 = str2;
            }
            if ((i3 & 128) != 0) {
                str6 = balance.disableBrief;
            } else {
                str6 = str3;
            }
            if ((i3 & 256) != 0) {
                miniApp2 = balance.miniApp;
            } else {
                miniApp2 = miniApp;
            }
            return balance.copy(l17, l18, bool3, bool4, num2, str4, str5, str6, miniApp2);
        }

        public final boolean canUse() {
            Integer num = this.disable;
            if (num != null && num.intValue() == 0 && Intrinsics.areEqual(this.supportBalance, Boolean.TRUE)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Long getBalance() {
            return this.balance;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Long getTotalFee() {
            return this.totalFee;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Boolean getSupportBalance() {
            return this.supportBalance;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Boolean getHasRealName() {
            return this.hasRealName;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final MiniApp getMiniApp() {
            return this.miniApp;
        }

        @NotNull
        public final Balance copy(@Nullable Long balance, @Nullable Long totalFee, @Nullable Boolean supportBalance, @Nullable Boolean hasRealName, @Nullable Integer disable, @Nullable String disableComment, @Nullable String disableUrl, @Nullable String disableBrief, @Nullable MiniApp miniApp) {
            return new Balance(balance, totalFee, supportBalance, hasRealName, disable, disableComment, disableUrl, disableBrief, miniApp);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Balance)) {
                return false;
            }
            Balance balance = (Balance) other;
            if (Intrinsics.areEqual(this.balance, balance.balance) && Intrinsics.areEqual(this.totalFee, balance.totalFee) && Intrinsics.areEqual(this.supportBalance, balance.supportBalance) && Intrinsics.areEqual(this.hasRealName, balance.hasRealName) && Intrinsics.areEqual(this.disable, balance.disable) && Intrinsics.areEqual(this.disableComment, balance.disableComment) && Intrinsics.areEqual(this.disableUrl, balance.disableUrl) && Intrinsics.areEqual(this.disableBrief, balance.disableBrief) && Intrinsics.areEqual(this.miniApp, balance.miniApp)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final Long getBalance() {
            return this.balance;
        }

        @Nullable
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @Nullable
        public final Boolean getHasRealName() {
            return this.hasRealName;
        }

        @Nullable
        public final MiniApp getMiniApp() {
            return this.miniApp;
        }

        @Nullable
        public final Boolean getSupportBalance() {
            return this.supportBalance;
        }

        @Nullable
        public final Long getTotalFee() {
            return this.totalFee;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            Long l3 = this.balance;
            int i3 = 0;
            if (l3 == null) {
                hashCode = 0;
            } else {
                hashCode = l3.hashCode();
            }
            int i16 = hashCode * 31;
            Long l16 = this.totalFee;
            if (l16 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = l16.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            Boolean bool = this.supportBalance;
            if (bool == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = bool.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            Boolean bool2 = this.hasRealName;
            if (bool2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = bool2.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Integer num = this.disable;
            if (num == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str = this.disableComment;
            if (str == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str2 = this.disableUrl;
            if (str2 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str2.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            String str3 = this.disableBrief;
            if (str3 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str3.hashCode();
            }
            int i29 = (i28 + hashCode8) * 31;
            MiniApp miniApp = this.miniApp;
            if (miniApp != null) {
                i3 = miniApp.hashCode();
            }
            return i29 + i3;
        }

        public final void setBalance(@Nullable Long l3) {
            this.balance = l3;
        }

        public final void setHasRealName(@Nullable Boolean bool) {
            this.hasRealName = bool;
        }

        public final void setSupportBalance(@Nullable Boolean bool) {
            this.supportBalance = bool;
        }

        public final void setTotalFee(@Nullable Long l3) {
            this.totalFee = l3;
        }

        @NotNull
        public String toString() {
            return "Balance(balance=" + this.balance + ", totalFee=" + this.totalFee + ", supportBalance=" + this.supportBalance + ", hasRealName=" + this.hasRealName + ", disable=" + this.disable + ", disableComment=" + this.disableComment + ", disableUrl=" + this.disableUrl + ", disableBrief=" + this.disableBrief + ", miniApp=" + this.miniApp + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r75) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Long l3 = this.balance;
            if (l3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l3.longValue());
            }
            Long l16 = this.totalFee;
            if (l16 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeLong(l16.longValue());
            }
            Boolean bool = this.supportBalance;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Boolean bool2 = this.hasRealName;
            if (bool2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool2.booleanValue() ? 1 : 0);
            }
            Integer num = this.disable;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.disableComment);
            parcel.writeString(this.disableUrl);
            parcel.writeString(this.disableBrief);
            MiniApp miniApp = this.miniApp;
            if (miniApp == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                miniApp.writeToParcel(parcel, r75);
            }
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B}\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u009e\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u00100J\t\u00101\u001a\u00020\u000bH\u00d6\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u00d6\u0003J\t\u00106\u001a\u00020\u000bH\u00d6\u0001J\t\u00107\u001a\u00020\u0004H\u00d6\u0001J\u0019\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000bH\u00d6\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\"\u00a8\u0006>"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$Bank;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "bankName", "", "bankType", "bgColor", "bindSerial", "bindTail", "cardTail", "disable", "", "disableComment", "disableUrl", "disableBrief", "imageId", "indexInJSON", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBankName", "()Ljava/lang/String;", "getBankType", "getBgColor", "getBindSerial", "getBindTail", "getCardTail", "getDisable", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDisableBrief", "getDisableComment", "getDisableUrl", "getImageId", "getIndexInJSON", "setIndexInJSON", "(Ljava/lang/Integer;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tenpay/pay/model/PayChannelBean$Bank;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Bank extends PayChannelBean implements Parcelable {

        @SerializedName("bank_name")
        @Nullable
        private final String bankName;

        @SerializedName("bank_type")
        @Nullable
        private final String bankType;

        @SerializedName(LayoutAttrDefine.BG_Color)
        @Nullable
        private final String bgColor;

        @SerializedName("bind_serial")
        @Nullable
        private final String bindSerial;

        @SerializedName("bind_tail")
        @Nullable
        private final String bindTail;

        @SerializedName("card_tail")
        @Nullable
        private final String cardTail;

        @SerializedName("disable")
        @Nullable
        private final Integer disable;

        @SerializedName("disable_title")
        @Nullable
        private final String disableBrief;

        @SerializedName("disable_comment")
        @Nullable
        private final String disableComment;

        @SerializedName("disable_url")
        @Nullable
        private final String disableUrl;

        @SerializedName("image_id")
        @Nullable
        private final String imageId;

        @Nullable
        private Integer indexInJSON;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<Bank> CREATOR = new Creator();

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$Bank$Companion;", "", "()V", "createList", "", "Lcom/tenpay/pay/model/PayChannelBean$Bank;", "qpayGateJSON", "Lorg/json/JSONObject;", "inGson", "Lcom/google/gson/Gson;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ List createList$default(Companion companion, JSONObject jSONObject, Gson gson, int i3, Object obj) {
                if ((i3 & 2) != 0) {
                    gson = null;
                }
                return companion.createList(jSONObject, gson);
            }

            @NotNull
            public final List<Bank> createList(@NotNull JSONObject qpayGateJSON, @Nullable Gson inGson) {
                Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
                if (inGson == null) {
                    inGson = new GsonBuilder().create();
                }
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = qpayGateJSON.optJSONArray("bind_banks");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        Bank bankChannel = (Bank) inGson.fromJson(optJSONArray.get(i3).toString(), Bank.class);
                        bankChannel.setIndexInJSON(Integer.valueOf(i3));
                        Intrinsics.checkNotNullExpressionValue(bankChannel, "bankChannel");
                        arrayList.add(bankChannel);
                    }
                }
                return arrayList;
            }

            Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<Bank> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Bank createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Bank(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Bank[] newArray(int i3) {
                return new Bank[i3];
            }
        }

        public Bank(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Integer num, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num2) {
            super(true, true, PayChannelUtils.BgRadiusEnum.NONE, 0, 8, null);
            this.bankName = str;
            this.bankType = str2;
            this.bgColor = str3;
            this.bindSerial = str4;
            this.bindTail = str5;
            this.cardTail = str6;
            this.disable = num;
            this.disableComment = str7;
            this.disableUrl = str8;
            this.disableBrief = str9;
            this.imageId = str10;
            this.indexInJSON = num2;
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getBankName() {
            return this.bankName;
        }

        @Nullable
        /* renamed from: component10, reason: from getter */
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        /* renamed from: component11, reason: from getter */
        public final String getImageId() {
            return this.imageId;
        }

        @Nullable
        /* renamed from: component12, reason: from getter */
        public final Integer getIndexInJSON() {
            return this.indexInJSON;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getBankType() {
            return this.bankType;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getBgColor() {
            return this.bgColor;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getBindSerial() {
            return this.bindSerial;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getBindTail() {
            return this.bindTail;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getCardTail() {
            return this.cardTail;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @NotNull
        public final Bank copy(@Nullable String bankName, @Nullable String bankType, @Nullable String bgColor, @Nullable String bindSerial, @Nullable String bindTail, @Nullable String cardTail, @Nullable Integer disable, @Nullable String disableComment, @Nullable String disableUrl, @Nullable String disableBrief, @Nullable String imageId, @Nullable Integer indexInJSON) {
            return new Bank(bankName, bankType, bgColor, bindSerial, bindTail, cardTail, disable, disableComment, disableUrl, disableBrief, imageId, indexInJSON);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Bank)) {
                return false;
            }
            Bank bank = (Bank) other;
            if (Intrinsics.areEqual(this.bankName, bank.bankName) && Intrinsics.areEqual(this.bankType, bank.bankType) && Intrinsics.areEqual(this.bgColor, bank.bgColor) && Intrinsics.areEqual(this.bindSerial, bank.bindSerial) && Intrinsics.areEqual(this.bindTail, bank.bindTail) && Intrinsics.areEqual(this.cardTail, bank.cardTail) && Intrinsics.areEqual(this.disable, bank.disable) && Intrinsics.areEqual(this.disableComment, bank.disableComment) && Intrinsics.areEqual(this.disableUrl, bank.disableUrl) && Intrinsics.areEqual(this.disableBrief, bank.disableBrief) && Intrinsics.areEqual(this.imageId, bank.imageId) && Intrinsics.areEqual(this.indexInJSON, bank.indexInJSON)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getBankName() {
            return this.bankName;
        }

        @Nullable
        public final String getBankType() {
            return this.bankType;
        }

        @Nullable
        public final String getBgColor() {
            return this.bgColor;
        }

        @Nullable
        public final String getBindSerial() {
            return this.bindSerial;
        }

        @Nullable
        public final String getBindTail() {
            return this.bindTail;
        }

        @Nullable
        public final String getCardTail() {
            return this.cardTail;
        }

        @Nullable
        public final Integer getDisable() {
            return this.disable;
        }

        @Nullable
        public final String getDisableBrief() {
            return this.disableBrief;
        }

        @Nullable
        public final String getDisableComment() {
            return this.disableComment;
        }

        @Nullable
        public final String getDisableUrl() {
            return this.disableUrl;
        }

        @Nullable
        public final String getImageId() {
            return this.imageId;
        }

        @Nullable
        public final Integer getIndexInJSON() {
            return this.indexInJSON;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            int hashCode9;
            int hashCode10;
            int hashCode11;
            String str = this.bankName;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.bankType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.bgColor;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.bindSerial;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.bindTail;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.cardTail;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            Integer num = this.disable;
            if (num == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = num.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            String str7 = this.disableComment;
            if (str7 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str7.hashCode();
            }
            int i29 = (i28 + hashCode8) * 31;
            String str8 = this.disableUrl;
            if (str8 == null) {
                hashCode9 = 0;
            } else {
                hashCode9 = str8.hashCode();
            }
            int i36 = (i29 + hashCode9) * 31;
            String str9 = this.disableBrief;
            if (str9 == null) {
                hashCode10 = 0;
            } else {
                hashCode10 = str9.hashCode();
            }
            int i37 = (i36 + hashCode10) * 31;
            String str10 = this.imageId;
            if (str10 == null) {
                hashCode11 = 0;
            } else {
                hashCode11 = str10.hashCode();
            }
            int i38 = (i37 + hashCode11) * 31;
            Integer num2 = this.indexInJSON;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return i38 + i3;
        }

        public final void setIndexInJSON(@Nullable Integer num) {
            this.indexInJSON = num;
        }

        @NotNull
        public String toString() {
            return "Bank(bankName=" + this.bankName + ", bankType=" + this.bankType + ", bgColor=" + this.bgColor + ", bindSerial=" + this.bindSerial + ", bindTail=" + this.bindTail + ", cardTail=" + this.cardTail + ", disable=" + this.disable + ", disableComment=" + this.disableComment + ", disableUrl=" + this.disableUrl + ", disableBrief=" + this.disableBrief + ", imageId=" + this.imageId + ", indexInJSON=" + this.indexInJSON + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r46) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bankName);
            parcel.writeString(this.bankType);
            parcel.writeString(this.bgColor);
            parcel.writeString(this.bindSerial);
            parcel.writeString(this.bindTail);
            parcel.writeString(this.cardTail);
            Integer num = this.disable;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            parcel.writeString(this.disableComment);
            parcel.writeString(this.disableUrl);
            parcel.writeString(this.disableBrief);
            parcel.writeString(this.imageId);
            Integer num2 = this.indexInJSON;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u0085\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0002\u0010\u0014J\u0006\u00104\u001a\u000205J\u0010\u00106\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u00107\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010:\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u0010\u0010?\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010@\u001a\u00020\u0004H\u00c6\u0003J\t\u0010A\u001a\u00020\rH\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u00a6\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00c6\u0001\u00a2\u0006\u0002\u0010DJ\t\u0010E\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010F\u001a\u0002052\b\u0010G\u001a\u0004\u0018\u00010HH\u00d6\u0003J\t\u0010I\u001a\u00020\u0004H\u00d6\u0001J\t\u0010J\u001a\u00020\u0007H\u00d6\u0001J\u0019\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0004H\u00d6\u0001R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010+R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001aR\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b/\u0010\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006Q"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "showPos", "", "flag", "reason", "", "pfaLogoId", "allowMultiFlag", "allowMultiCounts", "iPayFrom", "totalFee", "", "desc", "payTokenId", "qpayGateString", "processFlag", "payResult", "Lcom/tenpay/pay/FriendPayController$FriendPayResult;", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/tenpay/pay/FriendPayController$FriendPayResult;)V", "getAllowMultiCounts", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAllowMultiFlag", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getFlag", "getIPayFrom", "()I", "setIPayFrom", "(I)V", "getPayResult", "()Lcom/tenpay/pay/FriendPayController$FriendPayResult;", "setPayResult", "(Lcom/tenpay/pay/FriendPayController$FriendPayResult;)V", "getPayTokenId", "setPayTokenId", "getPfaLogoId", "getProcessFlag", "setProcessFlag", "(Ljava/lang/Integer;)V", "getQpayGateString", "setQpayGateString", "getReason", "getShowPos", "getTotalFee", "()J", "setTotalFee", "(J)V", "canUse", "", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/tenpay/pay/FriendPayController$FriendPayResult;)Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class FriendPay extends PayChannelBean implements Parcelable {

        @SerializedName("allow_multi_counts")
        @Nullable
        private final Integer allowMultiCounts;

        @SerializedName("allow_multi_flag")
        @Nullable
        private final Integer allowMultiFlag;

        @Nullable
        private String desc;

        @Nullable
        private final Integer flag;
        private int iPayFrom;

        @Nullable
        private FriendPayController.FriendPayResult payResult;

        @Nullable
        private String payTokenId;

        @SerializedName("pfa_logo_id")
        @Nullable
        private final String pfaLogoId;

        @Nullable
        private Integer processFlag;

        @Nullable
        private String qpayGateString;

        @Nullable
        private final String reason;

        @SerializedName("show_pos")
        @Nullable
        private final Integer showPos;
        private long totalFee;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final Parcelable.Creator<FriendPay> CREATOR = new Creator();

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$FriendPay$Companion;", "", "()V", OperateCustomButton.OPERATE_CREATE, "Lcom/tenpay/pay/model/PayChannelBean$FriendPay;", "qpayGateJSON", "Lorg/json/JSONObject;", "gsonInstance", "Lcom/google/gson/Gson;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public static /* synthetic */ FriendPay create$default(Companion companion, JSONObject jSONObject, Gson gson, int i3, Object obj) {
                if ((i3 & 2) != 0) {
                    gson = null;
                }
                return companion.create(jSONObject, gson);
            }

            @Nullable
            public final FriendPay create(@NotNull JSONObject qpayGateJSON, @Nullable Gson gson) {
                Intrinsics.checkNotNullParameter(qpayGateJSON, "qpayGateJSON");
                if (gson == null) {
                    try {
                        gson = new GsonBuilder().create();
                    } catch (Exception e16) {
                        QLog.w("PayChannelBean.FriendPay", 1, "create FriendPay fail: ", e16);
                        return null;
                    }
                }
                JSONObject optJSONObject = qpayGateJSON.optJSONObject("pfa_param");
                if (optJSONObject != null) {
                    Object fromJson = gson.fromJson(optJSONObject.toString(), (Class<Object>) FriendPay.class);
                    FriendPay friendPay = (FriendPay) fromJson;
                    friendPay.setTotalFee(qpayGateJSON.optLong("total_fee"));
                    friendPay.setDesc(qpayGateJSON.optString("desc"));
                    friendPay.setQpayGateString(qpayGateJSON.toString());
                    return (FriendPay) fromJson;
                }
                return null;
            }

            Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<FriendPay> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FriendPay createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new FriendPay(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? FriendPayController.FriendPayResult.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FriendPay[] newArray(int i3) {
                return new FriendPay[i3];
            }
        }

        public /* synthetic */ FriendPay(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, int i3, long j3, String str3, String str4, String str5, Integer num5, FriendPayController.FriendPayResult friendPayResult, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(num, num2, str, str2, num3, num4, i3, j3, str3, str4, str5, num5, (i16 & 4096) != 0 ? null : friendPayResult);
        }

        public final boolean canUse() {
            Integer num = this.showPos;
            if (num == null || (num.intValue() & 1) != 1) {
                return false;
            }
            return true;
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Integer getShowPos() {
            return this.showPos;
        }

        @Nullable
        /* renamed from: component10, reason: from getter */
        public final String getPayTokenId() {
            return this.payTokenId;
        }

        @Nullable
        /* renamed from: component11, reason: from getter */
        public final String getQpayGateString() {
            return this.qpayGateString;
        }

        @Nullable
        /* renamed from: component12, reason: from getter */
        public final Integer getProcessFlag() {
            return this.processFlag;
        }

        @Nullable
        /* renamed from: component13, reason: from getter */
        public final FriendPayController.FriendPayResult getPayResult() {
            return this.payResult;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final Integer getFlag() {
            return this.flag;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getPfaLogoId() {
            return this.pfaLogoId;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final Integer getAllowMultiFlag() {
            return this.allowMultiFlag;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final Integer getAllowMultiCounts() {
            return this.allowMultiCounts;
        }

        /* renamed from: component7, reason: from getter */
        public final int getIPayFrom() {
            return this.iPayFrom;
        }

        /* renamed from: component8, reason: from getter */
        public final long getTotalFee() {
            return this.totalFee;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @NotNull
        public final FriendPay copy(@Nullable Integer showPos, @Nullable Integer flag, @Nullable String reason, @Nullable String pfaLogoId, @Nullable Integer allowMultiFlag, @Nullable Integer allowMultiCounts, int iPayFrom, long totalFee, @Nullable String desc, @Nullable String payTokenId, @Nullable String qpayGateString, @Nullable Integer processFlag, @Nullable FriendPayController.FriendPayResult payResult) {
            return new FriendPay(showPos, flag, reason, pfaLogoId, allowMultiFlag, allowMultiCounts, iPayFrom, totalFee, desc, payTokenId, qpayGateString, processFlag, payResult);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendPay)) {
                return false;
            }
            FriendPay friendPay = (FriendPay) other;
            if (Intrinsics.areEqual(this.showPos, friendPay.showPos) && Intrinsics.areEqual(this.flag, friendPay.flag) && Intrinsics.areEqual(this.reason, friendPay.reason) && Intrinsics.areEqual(this.pfaLogoId, friendPay.pfaLogoId) && Intrinsics.areEqual(this.allowMultiFlag, friendPay.allowMultiFlag) && Intrinsics.areEqual(this.allowMultiCounts, friendPay.allowMultiCounts) && this.iPayFrom == friendPay.iPayFrom && this.totalFee == friendPay.totalFee && Intrinsics.areEqual(this.desc, friendPay.desc) && Intrinsics.areEqual(this.payTokenId, friendPay.payTokenId) && Intrinsics.areEqual(this.qpayGateString, friendPay.qpayGateString) && Intrinsics.areEqual(this.processFlag, friendPay.processFlag) && Intrinsics.areEqual(this.payResult, friendPay.payResult)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final Integer getAllowMultiCounts() {
            return this.allowMultiCounts;
        }

        @Nullable
        public final Integer getAllowMultiFlag() {
            return this.allowMultiFlag;
        }

        @Nullable
        public final String getDesc() {
            return this.desc;
        }

        @Nullable
        public final Integer getFlag() {
            return this.flag;
        }

        public final int getIPayFrom() {
            return this.iPayFrom;
        }

        @Nullable
        public final FriendPayController.FriendPayResult getPayResult() {
            return this.payResult;
        }

        @Nullable
        public final String getPayTokenId() {
            return this.payTokenId;
        }

        @Nullable
        public final String getPfaLogoId() {
            return this.pfaLogoId;
        }

        @Nullable
        public final Integer getProcessFlag() {
            return this.processFlag;
        }

        @Nullable
        public final String getQpayGateString() {
            return this.qpayGateString;
        }

        @Nullable
        public final String getReason() {
            return this.reason;
        }

        @Nullable
        public final Integer getShowPos() {
            return this.showPos;
        }

        public final long getTotalFee() {
            return this.totalFee;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            int hashCode8;
            int hashCode9;
            int hashCode10;
            Integer num = this.showPos;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num2 = this.flag;
            if (num2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = num2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str = this.reason;
            if (str == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str2 = this.pfaLogoId;
            if (str2 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str2.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            Integer num3 = this.allowMultiFlag;
            if (num3 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = num3.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            Integer num4 = this.allowMultiCounts;
            if (num4 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = num4.hashCode();
            }
            int a16 = (((((i26 + hashCode6) * 31) + this.iPayFrom) * 31) + a.a(this.totalFee)) * 31;
            String str3 = this.desc;
            if (str3 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str3.hashCode();
            }
            int i27 = (a16 + hashCode7) * 31;
            String str4 = this.payTokenId;
            if (str4 == null) {
                hashCode8 = 0;
            } else {
                hashCode8 = str4.hashCode();
            }
            int i28 = (i27 + hashCode8) * 31;
            String str5 = this.qpayGateString;
            if (str5 == null) {
                hashCode9 = 0;
            } else {
                hashCode9 = str5.hashCode();
            }
            int i29 = (i28 + hashCode9) * 31;
            Integer num5 = this.processFlag;
            if (num5 == null) {
                hashCode10 = 0;
            } else {
                hashCode10 = num5.hashCode();
            }
            int i36 = (i29 + hashCode10) * 31;
            FriendPayController.FriendPayResult friendPayResult = this.payResult;
            if (friendPayResult != null) {
                i3 = friendPayResult.hashCode();
            }
            return i36 + i3;
        }

        public final void setDesc(@Nullable String str) {
            this.desc = str;
        }

        public final void setIPayFrom(int i3) {
            this.iPayFrom = i3;
        }

        public final void setPayResult(@Nullable FriendPayController.FriendPayResult friendPayResult) {
            this.payResult = friendPayResult;
        }

        public final void setPayTokenId(@Nullable String str) {
            this.payTokenId = str;
        }

        public final void setProcessFlag(@Nullable Integer num) {
            this.processFlag = num;
        }

        public final void setQpayGateString(@Nullable String str) {
            this.qpayGateString = str;
        }

        public final void setTotalFee(long j3) {
            this.totalFee = j3;
        }

        @NotNull
        public String toString() {
            return "FriendPay(showPos=" + this.showPos + ", flag=" + this.flag + ", reason=" + this.reason + ", pfaLogoId=" + this.pfaLogoId + ", allowMultiFlag=" + this.allowMultiFlag + ", allowMultiCounts=" + this.allowMultiCounts + ", iPayFrom=" + this.iPayFrom + ", totalFee=" + this.totalFee + ", desc=" + this.desc + ", payTokenId=" + this.payTokenId + ", qpayGateString=" + this.qpayGateString + ", processFlag=" + this.processFlag + ", payResult=" + this.payResult + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r75) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Integer num = this.showPos;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Integer num2 = this.flag;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
            parcel.writeString(this.reason);
            parcel.writeString(this.pfaLogoId);
            Integer num3 = this.allowMultiFlag;
            if (num3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num3.intValue());
            }
            Integer num4 = this.allowMultiCounts;
            if (num4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num4.intValue());
            }
            parcel.writeInt(this.iPayFrom);
            parcel.writeLong(this.totalFee);
            parcel.writeString(this.desc);
            parcel.writeString(this.payTokenId);
            parcel.writeString(this.qpayGateString);
            Integer num5 = this.processFlag;
            if (num5 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num5.intValue());
            }
            FriendPayController.FriendPayResult friendPayResult = this.payResult;
            if (friendPayResult == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                friendPayResult.writeToParcel(parcel, r75);
            }
        }

        public FriendPay(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable String str2, @Nullable Integer num3, @Nullable Integer num4, int i3, long j3, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Integer num5, @Nullable FriendPayController.FriendPayResult friendPayResult) {
            super(false, false, PayChannelUtils.BgRadiusEnum.BottomRound, 0, 8, null);
            this.showPos = num;
            this.flag = num2;
            this.reason = str;
            this.pfaLogoId = str2;
            this.allowMultiFlag = num3;
            this.allowMultiCounts = num4;
            this.iPayFrom = i3;
            this.totalFee = j3;
            this.desc = str3;
            this.payTokenId = str4;
            this.qpayGateString = str5;
            this.processFlag = num5;
            this.payResult = friendPayResult;
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$MiniApp;", "Landroid/os/Parcelable;", "title", "", "logoId", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLogoId", "()Ljava/lang/String;", "getTitle", "getUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class MiniApp implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<MiniApp> CREATOR = new Creator();

        @SerializedName("logo_id")
        @Nullable
        private final String logoId;

        @Nullable
        private final String title;

        @Nullable
        private final String url;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<MiniApp> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MiniApp createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new MiniApp(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final MiniApp[] newArray(int i3) {
                return new MiniApp[i3];
            }
        }

        public MiniApp(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.title = str;
            this.logoId = str2;
            this.url = str3;
        }

        public static /* synthetic */ MiniApp copy$default(MiniApp miniApp, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = miniApp.title;
            }
            if ((i3 & 2) != 0) {
                str2 = miniApp.logoId;
            }
            if ((i3 & 4) != 0) {
                str3 = miniApp.url;
            }
            return miniApp.copy(str, str2, str3);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final MiniApp copy(@Nullable String title, @Nullable String logoId, @Nullable String url) {
            return new MiniApp(title, logoId, url);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MiniApp)) {
                return false;
            }
            MiniApp miniApp = (MiniApp) other;
            if (Intrinsics.areEqual(this.title, miniApp.title) && Intrinsics.areEqual(this.logoId, miniApp.logoId) && Intrinsics.areEqual(this.url, miniApp.url)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.title;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.logoId;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.url;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "MiniApp(title=" + this.title + ", logoId=" + this.logoId + ", url=" + this.url + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r26) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.title);
            parcel.writeString(this.logoId);
            parcel.writeString(this.url);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u00d6\u0001R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$More;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "logoResId", "", "title", "", "(ILjava/lang/String;)V", "getLogoResId", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class More extends PayChannelBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<More> CREATOR = new Creator();
        private final int logoResId;

        @NotNull
        private final String title;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<More> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final More createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new More(parcel.readInt(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final More[] newArray(int i3) {
                return new More[i3];
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public More(int i3, @NotNull String title) {
            super(false, false, PayChannelUtils.BgRadiusEnum.BottomRound, 0, 8, null);
            Intrinsics.checkNotNullParameter(title, "title");
            this.logoResId = i3;
            this.title = title;
        }

        public static /* synthetic */ More copy$default(More more, int i3, String str, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = more.logoResId;
            }
            if ((i16 & 2) != 0) {
                str = more.title;
            }
            return more.copy(i3, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLogoResId() {
            return this.logoResId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final More copy(int logoResId, @NotNull String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            return new More(logoResId, title);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof More)) {
                return false;
            }
            More more = (More) other;
            if (this.logoResId == more.logoResId && Intrinsics.areEqual(this.title, more.title)) {
                return true;
            }
            return false;
        }

        public final int getLogoResId() {
            return this.logoResId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            return (this.logoResId * 31) + this.title.hashCode();
        }

        @NotNull
        public String toString() {
            return "More(logoResId=" + this.logoResId + ", title=" + this.title + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r26) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.logoResId);
            parcel.writeString(this.title);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u00d6\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$QQHeader;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "logoId", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getLogoId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class QQHeader extends PayChannelBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<QQHeader> CREATOR = new Creator();

        @SerializedName("logo_id")
        @Nullable
        private final String logoId;

        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<QQHeader> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final QQHeader createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new QQHeader(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final QQHeader[] newArray(int i3) {
                return new QQHeader[i3];
            }
        }

        public QQHeader(@Nullable String str, @Nullable String str2) {
            super(true, false, PayChannelUtils.BgRadiusEnum.TopRound, 0, 8, null);
            this.logoId = str;
            this.title = str2;
        }

        public static /* synthetic */ QQHeader copy$default(QQHeader qQHeader, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = qQHeader.logoId;
            }
            if ((i3 & 2) != 0) {
                str2 = qQHeader.title;
            }
            return qQHeader.copy(str, str2);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final QQHeader copy(@Nullable String logoId, @Nullable String title) {
            return new QQHeader(logoId, title);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QQHeader)) {
                return false;
            }
            QQHeader qQHeader = (QQHeader) other;
            if (Intrinsics.areEqual(this.logoId, qQHeader.logoId) && Intrinsics.areEqual(this.title, qQHeader.title)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode;
            String str = this.logoId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.title;
            if (str2 != null) {
                i3 = str2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "QQHeader(logoId=" + this.logoId + ", title=" + this.title + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r26) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.logoId);
            parcel.writeString(this.title);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J]\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u00d6\u0003J\t\u0010%\u001a\u00020 H\u00d6\u0001J\t\u0010&\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020 H\u00d6\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\r\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r\u00a8\u0006,"}, d2 = {"Lcom/tenpay/pay/model/PayChannelBean$Wx;", "Landroid/os/Parcelable;", "Lcom/tenpay/pay/model/PayChannelBean;", "appId", "", "info", "logoId", "title", "url", "tokenId", "comeFrom", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getComeFrom", "setComeFrom", "(Ljava/lang/String;)V", "getInfo", "getLogoId", "getTitle", "getTokenId", "setTokenId", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", WadlProxyConsts.FLAGS, "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class Wx extends PayChannelBean implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<Wx> CREATOR = new Creator();

        @SerializedName("appid")
        @Nullable
        private final String appId;

        @Nullable
        private String comeFrom;

        @SerializedName("info")
        @Nullable
        private final String info;

        @SerializedName("logo_id")
        @Nullable
        private final String logoId;

        @SerializedName("title")
        @Nullable
        private final String title;

        @Nullable
        private String tokenId;

        @SerializedName("url")
        @Nullable
        private final String url;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Creator implements Parcelable.Creator<Wx> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wx createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Wx(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wx[] newArray(int i3) {
                return new Wx[i3];
            }
        }

        public Wx(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            super(true, false, PayChannelUtils.BgRadiusEnum.BothRound, 0, 8, null);
            this.appId = str;
            this.info = str2;
            this.logoId = str3;
            this.title = str4;
            this.url = str5;
            this.tokenId = str6;
            this.comeFrom = str7;
        }

        public static /* synthetic */ Wx copy$default(Wx wx5, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = wx5.appId;
            }
            if ((i3 & 2) != 0) {
                str2 = wx5.info;
            }
            String str8 = str2;
            if ((i3 & 4) != 0) {
                str3 = wx5.logoId;
            }
            String str9 = str3;
            if ((i3 & 8) != 0) {
                str4 = wx5.title;
            }
            String str10 = str4;
            if ((i3 & 16) != 0) {
                str5 = wx5.url;
            }
            String str11 = str5;
            if ((i3 & 32) != 0) {
                str6 = wx5.tokenId;
            }
            String str12 = str6;
            if ((i3 & 64) != 0) {
                str7 = wx5.comeFrom;
            }
            return wx5.copy(str, str8, str9, str10, str11, str12, str7);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getInfo() {
            return this.info;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getTokenId() {
            return this.tokenId;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getComeFrom() {
            return this.comeFrom;
        }

        @NotNull
        public final Wx copy(@Nullable String appId, @Nullable String info, @Nullable String logoId, @Nullable String title, @Nullable String url, @Nullable String tokenId, @Nullable String comeFrom) {
            return new Wx(appId, info, logoId, title, url, tokenId, comeFrom);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Wx)) {
                return false;
            }
            Wx wx5 = (Wx) other;
            if (Intrinsics.areEqual(this.appId, wx5.appId) && Intrinsics.areEqual(this.info, wx5.info) && Intrinsics.areEqual(this.logoId, wx5.logoId) && Intrinsics.areEqual(this.title, wx5.title) && Intrinsics.areEqual(this.url, wx5.url) && Intrinsics.areEqual(this.tokenId, wx5.tokenId) && Intrinsics.areEqual(this.comeFrom, wx5.comeFrom)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getAppId() {
            return this.appId;
        }

        @Nullable
        public final String getComeFrom() {
            return this.comeFrom;
        }

        @Nullable
        public final String getInfo() {
            return this.info;
        }

        @Nullable
        public final String getLogoId() {
            return this.logoId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTokenId() {
            return this.tokenId;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            String str = this.appId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.info;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.logoId;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.title;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.url;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.tokenId;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str7 = this.comeFrom;
            if (str7 != null) {
                i3 = str7.hashCode();
            }
            return i27 + i3;
        }

        public final void setComeFrom(@Nullable String str) {
            this.comeFrom = str;
        }

        public final void setTokenId(@Nullable String str) {
            this.tokenId = str;
        }

        @NotNull
        public String toString() {
            return "Wx(appId=" + this.appId + ", info=" + this.info + ", logoId=" + this.logoId + ", title=" + this.title + ", url=" + this.url + ", tokenId=" + this.tokenId + ", comeFrom=" + this.comeFrom + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int r26) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.appId);
            parcel.writeString(this.info);
            parcel.writeString(this.logoId);
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            parcel.writeString(this.tokenId);
            parcel.writeString(this.comeFrom);
        }
    }

    public /* synthetic */ PayChannelBean(boolean z16, boolean z17, PayChannelUtils.BgRadiusEnum bgRadiusEnum, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17, bgRadiusEnum, i3);
    }

    @NotNull
    public PayChannelUtils.BgRadiusEnum getBgRadiusEnum() {
        return this.bgRadiusEnum;
    }

    public int getSortPriority() {
        return this.sortPriority;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    /* renamed from: isCheck, reason: from getter */
    public final boolean getIsCheck() {
        return this.isCheck;
    }

    public void setBgRadiusEnum(@NotNull PayChannelUtils.BgRadiusEnum bgRadiusEnum) {
        Intrinsics.checkNotNullParameter(bgRadiusEnum, "<set-?>");
        this.bgRadiusEnum = bgRadiusEnum;
    }

    public final void setCheck(boolean z16) {
        this.isCheck = z16;
    }

    public void setSortPriority(int i3) {
        this.sortPriority = i3;
    }

    public final void setVisible(boolean z16) {
        this.visible = z16;
    }

    PayChannelBean(boolean z16, boolean z17, PayChannelUtils.BgRadiusEnum bgRadiusEnum, int i3) {
        this.visible = z16;
        this.isCheck = z17;
        this.bgRadiusEnum = bgRadiusEnum;
        this.sortPriority = i3;
    }

    public /* synthetic */ PayChannelBean(boolean z16, boolean z17, PayChannelUtils.BgRadiusEnum bgRadiusEnum, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, z17, bgRadiusEnum, (i16 & 8) != 0 ? 0 : i3, null);
    }
}
