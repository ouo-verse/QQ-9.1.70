package com.tencent.mobileqq.qqlive.room.prepare.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.kuikly.core.render.android.expand.module.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.kuikly.QQLiveKuiklyConfigUtils;
import com.tencent.mobileqq.qqlive.room.livelabel.LabelModel;
import com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetTeamBuildConfigRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import gr4.f;
import gr4.j;
import gr4.x;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nf4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 42\u00020\u00012\u00020\u0002:\u0003567B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u001b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001c\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010+\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010-\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010&R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "", "labelId", "", "secondTagId", "", "G9", VasPerfReportUtils.WHILE_UPDATE_ITEM, "H9", "Landroid/view/View;", "view", "F9", "I9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartDestroy", "v", NodeProps.ON_CLICK, "", "action", "", "args", "handleBroadcastMessage", "getMessage", "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$b;", "d", "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$b;", "roomInfoStage", "", "e", "Z", ViewStickEventHelper.IS_SHOW, "f", "Ljava/lang/String;", "startLiveAppId", h.F, "logoPicUrl", "i", "logoName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "detailSchema", "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", "gameData", "<init>", "(Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$b;)V", "D", "a", "GameData", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePreparePlayTogetherPart extends Part implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GameData gameData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b roomInfoStage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String startLiveAppId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String logoPicUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String logoName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String detailSchema;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001\u0012BC\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b!\u0010\"B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010#J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010 \u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "appId", "e", "getAppName", "appName", "f", "b", "downloadUrl", h.F, "packageName", "i", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "paramStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final /* data */ class GameData implements Parcelable {
        static IPatchRedirector $redirector_;

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String appId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String appName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String downloadUrl;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String packageName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String flags;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String paramStr;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$GameData;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart$GameData$a, reason: from kotlin metadata */
        /* loaded from: classes17.dex */
        public static final class Companion implements Parcelable.Creator<GameData> {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                    return;
                }
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public GameData createFromParcel(@NotNull Parcel parcel) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (GameData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new GameData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public GameData[] newArray(int size) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (GameData[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
                }
                return new GameData[size];
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36159);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 21)) {
                redirector.redirect((short) 21);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public GameData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, str6);
                return;
            }
            this.appId = str;
            this.appName = str2;
            this.downloadUrl = str3;
            this.packageName = str4;
            this.flags = str5;
            this.paramStr = str6;
        }

        @Nullable
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.appId;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.downloadUrl;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.flags;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return 0;
        }

        @Nullable
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.packageName;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof GameData)) {
                return false;
            }
            GameData gameData = (GameData) other;
            if (Intrinsics.areEqual(this.appId, gameData.appId) && Intrinsics.areEqual(this.appName, gameData.appName) && Intrinsics.areEqual(this.downloadUrl, gameData.downloadUrl) && Intrinsics.areEqual(this.packageName, gameData.packageName) && Intrinsics.areEqual(this.flags, gameData.flags) && Intrinsics.areEqual(this.paramStr, gameData.paramStr)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.paramStr;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
            }
            String str = this.appId;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.appName;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.downloadUrl;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.packageName;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.flags;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.paramStr;
            if (str6 != null) {
                i3 = str6.hashCode();
            }
            return i26 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return "GameData(appId=" + this.appId + ", appName=" + this.appName + ", downloadUrl=" + this.downloadUrl + ", packageName=" + this.packageName + ", flags=" + this.flags + ", paramStr=" + this.paramStr + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) parcel, flags);
                return;
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeString(this.appName);
            parcel.writeString(this.downloadUrl);
            parcel.writeString(this.packageName);
            parcel.writeString(this.flags);
            parcel.writeString(this.paramStr);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public GameData(@NotNull Parcel parcel) {
            this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$a;", "", "", "MSG_CAN_JUMP_PLAY_TOGETHER", "Ljava/lang/String;", "MSG_HANDLE_JUMP_PLAY_TOGETHER", "MSG_NOTIFY_LIVE_GAME_CHANGE", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/part/QQLivePreparePlayTogetherPart$b;", "", "", "getAnchorUid", "getRoomId", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        long getAnchorUid();

        long getRoomId();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePreparePlayTogetherPart(@NotNull b roomInfoStage) {
        Intrinsics.checkNotNullParameter(roomInfoStage, "roomInfoStage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomInfoStage);
            return;
        }
        this.roomInfoStage = roomInfoStage;
        this.isShow = true;
        this.startLiveAppId = "";
        this.logoPicUrl = "";
        this.logoName = "";
        this.detailSchema = "";
    }

    private final void F9(View view) {
        d.a.a(((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil(), view, false, null, "em_qqlive_play_together", new LinkedHashMap(), 4, null);
    }

    private final void G9(long labelId, int secondTagId) {
        String str;
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("taskid")) == null) {
            str = "";
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetTeamBuildConfigRequest(labelId, this.roomInfoStage.getAnchorUid(), this.roomInfoStage.getRoomId(), secondTagId, str), new Function1<QQLiveResponse<j>, Unit>() { // from class: com.tencent.mobileqq.qqlive.room.prepare.part.QQLivePreparePlayTogetherPart$fetchPlayTogetherConfig$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePreparePlayTogetherPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<j> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<j> response) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                j rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("Open_Live|QQLivePlayTogetherPart", "playTogetherConfig", "success");
                    x xVar = rsp.f403135b;
                    if (xVar != null) {
                        QQLivePreparePlayTogetherPart.this.isShow = rsp.f403134a;
                        QQLivePreparePlayTogetherPart qQLivePreparePlayTogetherPart = QQLivePreparePlayTogetherPart.this;
                        String str2 = xVar.f403237a;
                        Intrinsics.checkNotNullExpressionValue(str2, "config.appid");
                        qQLivePreparePlayTogetherPart.startLiveAppId = str2;
                        QQLivePreparePlayTogetherPart qQLivePreparePlayTogetherPart2 = QQLivePreparePlayTogetherPart.this;
                        String str3 = xVar.f403238b;
                        Intrinsics.checkNotNullExpressionValue(str3, "config.logoPic");
                        qQLivePreparePlayTogetherPart2.logoPicUrl = str3;
                        QQLivePreparePlayTogetherPart qQLivePreparePlayTogetherPart3 = QQLivePreparePlayTogetherPart.this;
                        String str4 = xVar.f403239c;
                        Intrinsics.checkNotNullExpressionValue(str4, "config.logoName");
                        qQLivePreparePlayTogetherPart3.logoName = str4;
                        QQLivePreparePlayTogetherPart qQLivePreparePlayTogetherPart4 = QQLivePreparePlayTogetherPart.this;
                        String str5 = xVar.f403240d;
                        Intrinsics.checkNotNullExpressionValue(str5, "config.detailSchema");
                        qQLivePreparePlayTogetherPart4.detailSchema = str5;
                        f fVar = xVar.f403241e;
                        if (fVar != null) {
                            QQLivePreparePlayTogetherPart.this.gameData = new QQLivePreparePlayTogetherPart.GameData(fVar.f403119a, fVar.f403120b, fVar.f403121c, fVar.f403123e, fVar.f403124f, fVar.f403125g);
                        }
                    }
                    QQLivePreparePlayTogetherPart.this.updateView();
                    return;
                }
                AegisLogger.INSTANCE.w("Open_Live|QQLivePlayTogetherPart", "playTogetherConfig", "failed, code=" + response.getRetCode() + ", msg=" + response.getErrMsg());
            }
        });
    }

    private final void H9() {
        ri2.a aVar = ri2.a.f431480a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        aVar.d(activity, this.detailSchema);
    }

    private final void I9() {
        this.isShow = false;
        this.startLiveAppId = "";
        this.logoPicUrl = "";
        this.logoName = "";
        this.detailSchema = "";
        this.gameData = null;
        updateView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView() {
        int i3;
        boolean z16;
        if (getPartRootView() == null) {
            return;
        }
        View findViewById = getPartRootView().findViewById(R.id.f61282xp);
        boolean z17 = false;
        if (this.isShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        findViewById.setVisibility(i3);
        findViewById.setOnClickListener(this);
        Intrinsics.checkNotNullExpressionValue(findViewById, "this");
        F9(findViewById);
        if (this.logoPicUrl.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ImageView imageView = (ImageView) getPartRootView().findViewById(R.id.f61272xo);
            URLDrawable drawable = URLDrawable.getDrawable(this.logoPicUrl, URLDrawable.URLDrawableOptions.obtain());
            Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(logoPicUrl, options)");
            imageView.setImageDrawable(drawable);
        }
        if (this.logoName.length() > 0) {
            z17 = true;
        }
        if (z17) {
            ((TextView) getPartRootView().findViewById(R.id.f61312xs)).setText(this.logoName);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        Object message;
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return iPatchRedirector.redirect((short) 7, (Object) this, (Object) action, args);
        }
        if (Intrinsics.areEqual(action, "MSG_CAN_JUMP_PLAY_TOGETHER")) {
            boolean z17 = false;
            if (this.isShow) {
                GameData gameData = this.gameData;
                if (gameData != null) {
                    str = gameData.a();
                } else {
                    str = null;
                }
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    z17 = true;
                }
            }
            message = Boolean.valueOf(z17);
        } else {
            message = super.getMessage(action, args);
        }
        Intrinsics.checkNotNullExpressionValue(message, "when(action) {\n         \u2026)\n            }\n        }");
        return message;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) action, args);
            return;
        }
        LabelModel labelModel = null;
        if (Intrinsics.areEqual(action, "MSG_NOTIFY_LIVE_GAME_CHANGE")) {
            I9();
            if (args instanceof LabelModel) {
                labelModel = (LabelModel) args;
            }
            if (labelModel == null) {
                return;
            }
            G9(labelModel.thirdLabelId, labelModel.secondId);
            return;
        }
        if (Intrinsics.areEqual(action, "MSG_HANDLE_JUMP_PLAY_TOGETHER")) {
            ri2.a.c(ri2.a.f431480a, this.gameData, null, 2, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) v3);
        } else if (!FastClickUtils.isFastDoubleClick("Open_Live|QQLivePlayTogetherPart") && v3 != null) {
            H9();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        QQLiveKuiklyConfigUtils.f271368a.a();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        Context context = getContext();
        if (context != null) {
            l.e(context, "notifyPageClose", new JSONObject());
        }
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
        }
    }
}
