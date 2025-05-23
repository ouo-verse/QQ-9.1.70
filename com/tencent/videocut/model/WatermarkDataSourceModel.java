package com.tencent.videocut.model;

import android.os.Parcelable;
import com.squareup.wire.AndroidMessage;
import com.squareup.wire.EnumAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireEnum;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.tencent.aio.widget.textView.param.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fBg\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014Jh\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "Lcom/squareup/wire/AndroidMessage;", "Lcom/tencent/videocut/model/WatermarkDataSourceModel$Builder;", "entityIdList", "", "", QAdRewardDefine$SecurityData.DATA_KEY, "", "isEditable", "", "menuTypeList", "Lcom/tencent/videocut/model/WatermarkDataSourceModel$MenuType;", "watermarkUserModel", "Lcom/tencent/videocut/model/WatermarkUserModel;", "watermarkDateModel", "Lcom/tencent/videocut/model/WatermarkDateModel;", "watermarkPoiModelWrapper", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", "unknownFields", "Lokio/ByteString;", "(Ljava/util/List;Ljava/lang/String;ZLjava/util/List;Lcom/tencent/videocut/model/WatermarkUserModel;Lcom/tencent/videocut/model/WatermarkDateModel;Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;Lokio/ByteString;)V", "copy", "equals", "other", "", "hashCode", "", "newBuilder", "toString", "Builder", "Companion", "MenuType", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class WatermarkDataSourceModel extends AndroidMessage<WatermarkDataSourceModel, Builder> {
    static IPatchRedirector $redirector_;

    @JvmField
    @NotNull
    public static final ProtoAdapter<WatermarkDataSourceModel> ADAPTER;

    @JvmField
    @NotNull
    public static final Parcelable.Creator<WatermarkDataSourceModel> CREATOR;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.OMIT_IDENTITY, tag = 2)
    @JvmField
    @NotNull
    public final String dataKey;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", label = WireField.Label.PACKED, tag = 1)
    @JvmField
    @NotNull
    public final List<Long> entityIdList;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", label = WireField.Label.OMIT_IDENTITY, tag = 3)
    @JvmField
    public final boolean isEditable;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkDataSourceModel$MenuType#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    @JvmField
    @NotNull
    public final List<MenuType> menuTypeList;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkDateModel#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 6)
    @JvmField
    @Nullable
    public final WatermarkDateModel watermarkDateModel;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkPoiModelWrapper#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 7)
    @JvmField
    @Nullable
    public final WatermarkPoiModelWrapper watermarkPoiModelWrapper;

    @WireField(adapter = "com.tencent.videocut.model.WatermarkUserModel#ADAPTER", label = WireField.Label.OMIT_IDENTITY, tag = 5)
    @JvmField
    @Nullable
    public final WatermarkUserModel watermarkUserModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/videocut/model/WatermarkDataSourceModel$Builder;", "Lcom/squareup/wire/Message$Builder;", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "()V", QAdRewardDefine$SecurityData.DATA_KEY, "", "entityIdList", "", "", "isEditable", "", "menuTypeList", "Lcom/tencent/videocut/model/WatermarkDataSourceModel$MenuType;", "watermarkDateModel", "Lcom/tencent/videocut/model/WatermarkDateModel;", "watermarkPoiModelWrapper", "Lcom/tencent/videocut/model/WatermarkPoiModelWrapper;", "watermarkUserModel", "Lcom/tencent/videocut/model/WatermarkUserModel;", "build", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Builder extends Message.Builder<WatermarkDataSourceModel, Builder> {
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public String dataKey;

        @JvmField
        @NotNull
        public List<Long> entityIdList;

        @JvmField
        public boolean isEditable;

        @JvmField
        @NotNull
        public List<? extends MenuType> menuTypeList;

        @JvmField
        @Nullable
        public WatermarkDateModel watermarkDateModel;

        @JvmField
        @Nullable
        public WatermarkPoiModelWrapper watermarkPoiModelWrapper;

        @JvmField
        @Nullable
        public WatermarkUserModel watermarkUserModel;

        public Builder() {
            List<Long> emptyList;
            List<? extends MenuType> emptyList2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                this.entityIdList = emptyList;
                this.dataKey = "";
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                this.menuTypeList = emptyList2;
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @NotNull
        public final Builder dataKey(@NotNull String dataKey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataKey);
            }
            Intrinsics.checkNotNullParameter(dataKey, "dataKey");
            this.dataKey = dataKey;
            return this;
        }

        @NotNull
        public final Builder entityIdList(@NotNull List<Long> entityIdList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) entityIdList);
            }
            Intrinsics.checkNotNullParameter(entityIdList, "entityIdList");
            Internal.checkElementsNotNull(entityIdList);
            this.entityIdList = entityIdList;
            return this;
        }

        @NotNull
        public final Builder isEditable(boolean isEditable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, isEditable);
            }
            this.isEditable = isEditable;
            return this;
        }

        @NotNull
        public final Builder menuTypeList(@NotNull List<? extends MenuType> menuTypeList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (Builder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) menuTypeList);
            }
            Intrinsics.checkNotNullParameter(menuTypeList, "menuTypeList");
            Internal.checkElementsNotNull(menuTypeList);
            this.menuTypeList = menuTypeList;
            return this;
        }

        @NotNull
        public final Builder watermarkDateModel(@Nullable WatermarkDateModel watermarkDateModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Builder) iPatchRedirector.redirect((short) 7, (Object) this, (Object) watermarkDateModel);
            }
            this.watermarkDateModel = watermarkDateModel;
            return this;
        }

        @NotNull
        public final Builder watermarkPoiModelWrapper(@Nullable WatermarkPoiModelWrapper watermarkPoiModelWrapper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Builder) iPatchRedirector.redirect((short) 8, (Object) this, (Object) watermarkPoiModelWrapper);
            }
            this.watermarkPoiModelWrapper = watermarkPoiModelWrapper;
            return this;
        }

        @NotNull
        public final Builder watermarkUserModel(@Nullable WatermarkUserModel watermarkUserModel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (Builder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) watermarkUserModel);
            }
            this.watermarkUserModel = watermarkUserModel;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        @NotNull
        public WatermarkDataSourceModel build() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? new WatermarkDataSourceModel(this.entityIdList, this.dataKey, this.isEditable, this.menuTypeList, this.watermarkUserModel, this.watermarkDateModel, this.watermarkPoiModelWrapper, buildUnknownFields()) : (WatermarkDataSourceModel) iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/model/WatermarkDataSourceModel$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/WatermarkDataSourceModel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "serialVersionUID", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/videocut/model/WatermarkDataSourceModel$MenuType;", "", "Lcom/squareup/wire/WireEnum;", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "NONE", "LOCATION", "DATE_TIME", "USER_INFO", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class MenuType implements WireEnum {
        private static final /* synthetic */ MenuType[] $VALUES;
        static IPatchRedirector $redirector_;

        @JvmField
        @NotNull
        public static final ProtoAdapter<MenuType> ADAPTER;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;
        public static final MenuType DATE_TIME;
        public static final MenuType LOCATION;
        public static final MenuType NONE;
        public static final MenuType USER_INFO;
        private final int value;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/model/WatermarkDataSourceModel$MenuType$Companion;", "", "()V", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/tencent/videocut/model/WatermarkDataSourceModel$MenuType;", "fromValue", "value", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            @JvmStatic
            @Nullable
            public final MenuType fromValue(int value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (MenuType) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
                if (value != 0) {
                    if (value != 1) {
                        if (value != 2) {
                            if (value != 3) {
                                return null;
                            }
                            return MenuType.USER_INFO;
                        }
                        return MenuType.DATE_TIME;
                    }
                    return MenuType.LOCATION;
                }
                return MenuType.NONE;
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static final /* synthetic */ MenuType[] $values() {
            return new MenuType[]{NONE, LOCATION, DATE_TIME, USER_INFO};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59404);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            final MenuType menuType = new MenuType("NONE", 0, 0);
            NONE = menuType;
            LOCATION = new MenuType("LOCATION", 1, 1);
            DATE_TIME = new MenuType("DATE_TIME", 2, 2);
            USER_INFO = new MenuType("USER_INFO", 3, 3);
            $VALUES = $values();
            INSTANCE = new Companion(null);
            final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MenuType.class);
            final Syntax syntax = Syntax.PROTO_3;
            ADAPTER = new EnumAdapter<MenuType>(orCreateKotlinClass, syntax, menuType) { // from class: com.tencent.videocut.model.WatermarkDataSourceModel$MenuType$Companion$ADAPTER$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(orCreateKotlinClass, syntax, menuType);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, orCreateKotlinClass, syntax, menuType);
                    }
                }

                @Override // com.squareup.wire.EnumAdapter
                @Nullable
                public WatermarkDataSourceModel.MenuType fromValue(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? WatermarkDataSourceModel.MenuType.INSTANCE.fromValue(value) : (WatermarkDataSourceModel.MenuType) iPatchRedirector.redirect((short) 2, (Object) this, value);
                }
            };
        }

        MenuType(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        @JvmStatic
        @Nullable
        public static final MenuType fromValue(int i3) {
            return INSTANCE.fromValue(i3);
        }

        public static MenuType valueOf(String str) {
            return (MenuType) Enum.valueOf(MenuType.class, str);
        }

        public static MenuType[] values() {
            return (MenuType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        final FieldEncoding fieldEncoding = FieldEncoding.LENGTH_DELIMITED;
        final KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(WatermarkDataSourceModel.class);
        final Syntax syntax = Syntax.PROTO_3;
        ProtoAdapter<WatermarkDataSourceModel> protoAdapter = new ProtoAdapter<WatermarkDataSourceModel>(fieldEncoding, orCreateKotlinClass, syntax) { // from class: com.tencent.videocut.model.WatermarkDataSourceModel$Companion$ADAPTER$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(fieldEncoding, orCreateKotlinClass, "type.googleapis.com/model.WatermarkDataSourceModel", syntax, (Object) null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, fieldEncoding, orCreateKotlinClass, syntax);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkDataSourceModel decode(@NotNull ProtoReader reader) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (WatermarkDataSourceModel) iPatchRedirector.redirect((short) 4, (Object) this, (Object) reader);
                }
                Intrinsics.checkNotNullParameter(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long beginMessage = reader.beginMessage();
                WatermarkUserModel watermarkUserModel = null;
                String str = "";
                boolean z16 = false;
                WatermarkDateModel watermarkDateModel = null;
                WatermarkPoiModelWrapper watermarkPoiModelWrapper = null;
                while (true) {
                    int nextTag = reader.nextTag();
                    if (nextTag != -1) {
                        switch (nextTag) {
                            case 1:
                                arrayList.add(ProtoAdapter.UINT64.decode(reader));
                                break;
                            case 2:
                                str = ProtoAdapter.STRING.decode(reader);
                                break;
                            case 3:
                                z16 = ProtoAdapter.BOOL.decode(reader).booleanValue();
                                break;
                            case 4:
                                try {
                                    arrayList2.add(WatermarkDataSourceModel.MenuType.ADAPTER.decode(reader));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e16) {
                                    reader.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e16.value));
                                    Unit unit = Unit.INSTANCE;
                                    break;
                                }
                            case 5:
                                watermarkUserModel = WatermarkUserModel.ADAPTER.decode(reader);
                                break;
                            case 6:
                                watermarkDateModel = WatermarkDateModel.ADAPTER.decode(reader);
                                break;
                            case 7:
                                watermarkPoiModelWrapper = WatermarkPoiModelWrapper.ADAPTER.decode(reader);
                                break;
                            default:
                                reader.readUnknownField(nextTag);
                                break;
                        }
                    } else {
                        return new WatermarkDataSourceModel(arrayList, str, z16, arrayList2, watermarkUserModel, watermarkDateModel, watermarkPoiModelWrapper, reader.endMessageAndGetUnknownFields(beginMessage));
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(@NotNull ProtoWriter writer, @NotNull WatermarkDataSourceModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) writer, (Object) value);
                    return;
                }
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                ProtoAdapter.UINT64.asPacked().encodeWithTag(writer, 1, value.entityIdList);
                if (!Intrinsics.areEqual(value.dataKey, "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.dataKey);
                }
                boolean z16 = value.isEditable;
                if (z16) {
                    ProtoAdapter.BOOL.encodeWithTag(writer, 3, Boolean.valueOf(z16));
                }
                WatermarkDataSourceModel.MenuType.ADAPTER.asRepeated().encodeWithTag(writer, 4, value.menuTypeList);
                WatermarkUserModel watermarkUserModel = value.watermarkUserModel;
                if (watermarkUserModel != null) {
                    WatermarkUserModel.ADAPTER.encodeWithTag(writer, 5, watermarkUserModel);
                }
                WatermarkDateModel watermarkDateModel = value.watermarkDateModel;
                if (watermarkDateModel != null) {
                    WatermarkDateModel.ADAPTER.encodeWithTag(writer, 6, watermarkDateModel);
                }
                WatermarkPoiModelWrapper watermarkPoiModelWrapper = value.watermarkPoiModelWrapper;
                if (watermarkPoiModelWrapper != null) {
                    WatermarkPoiModelWrapper.ADAPTER.encodeWithTag(writer, 7, watermarkPoiModelWrapper);
                }
                writer.writeBytes(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(@NotNull WatermarkDataSourceModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) value)).intValue();
                }
                Intrinsics.checkNotNullParameter(value, "value");
                int size = value.unknownFields().size() + ProtoAdapter.UINT64.asPacked().encodedSizeWithTag(1, value.entityIdList);
                if (!Intrinsics.areEqual(value.dataKey, "")) {
                    size += ProtoAdapter.STRING.encodedSizeWithTag(2, value.dataKey);
                }
                boolean z16 = value.isEditable;
                if (z16) {
                    size += ProtoAdapter.BOOL.encodedSizeWithTag(3, Boolean.valueOf(z16));
                }
                int encodedSizeWithTag = size + WatermarkDataSourceModel.MenuType.ADAPTER.asRepeated().encodedSizeWithTag(4, value.menuTypeList);
                WatermarkUserModel watermarkUserModel = value.watermarkUserModel;
                if (watermarkUserModel != null) {
                    encodedSizeWithTag += WatermarkUserModel.ADAPTER.encodedSizeWithTag(5, watermarkUserModel);
                }
                WatermarkDateModel watermarkDateModel = value.watermarkDateModel;
                if (watermarkDateModel != null) {
                    encodedSizeWithTag += WatermarkDateModel.ADAPTER.encodedSizeWithTag(6, watermarkDateModel);
                }
                WatermarkPoiModelWrapper watermarkPoiModelWrapper = value.watermarkPoiModelWrapper;
                return watermarkPoiModelWrapper != null ? encodedSizeWithTag + WatermarkPoiModelWrapper.ADAPTER.encodedSizeWithTag(7, watermarkPoiModelWrapper) : encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            @NotNull
            public WatermarkDataSourceModel redact(@NotNull WatermarkDataSourceModel value) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (WatermarkDataSourceModel) iPatchRedirector.redirect((short) 5, (Object) this, (Object) value);
                }
                Intrinsics.checkNotNullParameter(value, "value");
                WatermarkUserModel watermarkUserModel = value.watermarkUserModel;
                WatermarkUserModel redact = watermarkUserModel != null ? WatermarkUserModel.ADAPTER.redact(watermarkUserModel) : null;
                WatermarkDateModel watermarkDateModel = value.watermarkDateModel;
                WatermarkDateModel redact2 = watermarkDateModel != null ? WatermarkDateModel.ADAPTER.redact(watermarkDateModel) : null;
                WatermarkPoiModelWrapper watermarkPoiModelWrapper = value.watermarkPoiModelWrapper;
                return WatermarkDataSourceModel.copy$default(value, null, null, false, null, redact, redact2, watermarkPoiModelWrapper != null ? WatermarkPoiModelWrapper.ADAPTER.redact(watermarkPoiModelWrapper) : null, ByteString.EMPTY, 15, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = AndroidMessage.INSTANCE.newCreator(protoAdapter);
    }

    public WatermarkDataSourceModel() {
        this(null, null, false, null, null, null, null, null, 255, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    public static /* synthetic */ WatermarkDataSourceModel copy$default(WatermarkDataSourceModel watermarkDataSourceModel, List list, String str, boolean z16, List list2, WatermarkUserModel watermarkUserModel, WatermarkDateModel watermarkDateModel, WatermarkPoiModelWrapper watermarkPoiModelWrapper, ByteString byteString, int i3, Object obj) {
        List list3;
        String str2;
        boolean z17;
        List list4;
        WatermarkUserModel watermarkUserModel2;
        WatermarkDateModel watermarkDateModel2;
        WatermarkPoiModelWrapper watermarkPoiModelWrapper2;
        ByteString byteString2;
        if ((i3 & 1) != 0) {
            list3 = watermarkDataSourceModel.entityIdList;
        } else {
            list3 = list;
        }
        if ((i3 & 2) != 0) {
            str2 = watermarkDataSourceModel.dataKey;
        } else {
            str2 = str;
        }
        if ((i3 & 4) != 0) {
            z17 = watermarkDataSourceModel.isEditable;
        } else {
            z17 = z16;
        }
        if ((i3 & 8) != 0) {
            list4 = watermarkDataSourceModel.menuTypeList;
        } else {
            list4 = list2;
        }
        if ((i3 & 16) != 0) {
            watermarkUserModel2 = watermarkDataSourceModel.watermarkUserModel;
        } else {
            watermarkUserModel2 = watermarkUserModel;
        }
        if ((i3 & 32) != 0) {
            watermarkDateModel2 = watermarkDataSourceModel.watermarkDateModel;
        } else {
            watermarkDateModel2 = watermarkDateModel;
        }
        if ((i3 & 64) != 0) {
            watermarkPoiModelWrapper2 = watermarkDataSourceModel.watermarkPoiModelWrapper;
        } else {
            watermarkPoiModelWrapper2 = watermarkPoiModelWrapper;
        }
        if ((i3 & 128) != 0) {
            byteString2 = watermarkDataSourceModel.unknownFields();
        } else {
            byteString2 = byteString;
        }
        return watermarkDataSourceModel.copy(list3, str2, z17, list4, watermarkUserModel2, watermarkDateModel2, watermarkPoiModelWrapper2, byteString2);
    }

    @NotNull
    public final WatermarkDataSourceModel copy(@NotNull List<Long> entityIdList, @NotNull String dataKey, boolean isEditable, @NotNull List<? extends MenuType> menuTypeList, @Nullable WatermarkUserModel watermarkUserModel, @Nullable WatermarkDateModel watermarkDateModel, @Nullable WatermarkPoiModelWrapper watermarkPoiModelWrapper, @NotNull ByteString unknownFields) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (WatermarkDataSourceModel) iPatchRedirector.redirect((short) 7, this, entityIdList, dataKey, Boolean.valueOf(isEditable), menuTypeList, watermarkUserModel, watermarkDateModel, watermarkPoiModelWrapper, unknownFields);
        }
        Intrinsics.checkNotNullParameter(entityIdList, "entityIdList");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        Intrinsics.checkNotNullParameter(menuTypeList, "menuTypeList");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        return new WatermarkDataSourceModel(entityIdList, dataKey, isEditable, menuTypeList, watermarkUserModel, watermarkDateModel, watermarkPoiModelWrapper, unknownFields);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, other)).booleanValue();
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof WatermarkDataSourceModel)) {
            return false;
        }
        WatermarkDataSourceModel watermarkDataSourceModel = (WatermarkDataSourceModel) other;
        if (Intrinsics.areEqual(unknownFields(), watermarkDataSourceModel.unknownFields()) && Intrinsics.areEqual(this.entityIdList, watermarkDataSourceModel.entityIdList) && Intrinsics.areEqual(this.dataKey, watermarkDataSourceModel.dataKey) && this.isEditable == watermarkDataSourceModel.isEditable && Intrinsics.areEqual(this.menuTypeList, watermarkDataSourceModel.menuTypeList) && Intrinsics.areEqual(this.watermarkUserModel, watermarkDataSourceModel.watermarkUserModel) && Intrinsics.areEqual(this.watermarkDateModel, watermarkDataSourceModel.watermarkDateModel) && Intrinsics.areEqual(this.watermarkPoiModelWrapper, watermarkDataSourceModel.watermarkPoiModelWrapper)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int i17 = this.hashCode;
        if (i17 == 0) {
            int hashCode = ((((((((unknownFields().hashCode() * 37) + this.entityIdList.hashCode()) * 37) + this.dataKey.hashCode()) * 37) + a.a(this.isEditable)) * 37) + this.menuTypeList.hashCode()) * 37;
            WatermarkUserModel watermarkUserModel = this.watermarkUserModel;
            int i18 = 0;
            if (watermarkUserModel != null) {
                i3 = watermarkUserModel.hashCode();
            } else {
                i3 = 0;
            }
            int i19 = (hashCode + i3) * 37;
            WatermarkDateModel watermarkDateModel = this.watermarkDateModel;
            if (watermarkDateModel != null) {
                i16 = watermarkDateModel.hashCode();
            } else {
                i16 = 0;
            }
            int i26 = (i19 + i16) * 37;
            WatermarkPoiModelWrapper watermarkPoiModelWrapper = this.watermarkPoiModelWrapper;
            if (watermarkPoiModelWrapper != null) {
                i18 = watermarkPoiModelWrapper.hashCode();
            }
            int i27 = i26 + i18;
            this.hashCode = i27;
            return i27;
        }
        return i17;
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public String toString() {
        String joinToString$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        if (!this.entityIdList.isEmpty()) {
            arrayList.add("entityIdList=" + this.entityIdList);
        }
        arrayList.add("dataKey=" + Internal.sanitize(this.dataKey));
        arrayList.add("isEditable=" + this.isEditable);
        if (!this.menuTypeList.isEmpty()) {
            arrayList.add("menuTypeList=" + this.menuTypeList);
        }
        WatermarkUserModel watermarkUserModel = this.watermarkUserModel;
        if (watermarkUserModel != null) {
            arrayList.add("watermarkUserModel=" + watermarkUserModel);
        }
        WatermarkDateModel watermarkDateModel = this.watermarkDateModel;
        if (watermarkDateModel != null) {
            arrayList.add("watermarkDateModel=" + watermarkDateModel);
        }
        WatermarkPoiModelWrapper watermarkPoiModelWrapper = this.watermarkPoiModelWrapper;
        if (watermarkPoiModelWrapper != null) {
            arrayList.add("watermarkPoiModelWrapper=" + watermarkPoiModelWrapper);
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ", ", "WatermarkDataSourceModel{", "}", 0, null, null, 56, null);
        return joinToString$default;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ WatermarkDataSourceModel(List list, String str, boolean z16, List list2, WatermarkUserModel watermarkUserModel, WatermarkDateModel watermarkDateModel, WatermarkPoiModelWrapper watermarkPoiModelWrapper, ByteString byteString, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, r5, r6, (i3 & 16) != 0 ? null : watermarkUserModel, (i3 & 32) != 0 ? null : watermarkDateModel, (i3 & 64) != 0 ? null : watermarkPoiModelWrapper, (i3 & 128) != 0 ? ByteString.EMPTY : byteString);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        if ((i3 & 1) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        String str2 = (i3 & 2) != 0 ? "" : str;
        boolean z17 = (i3 & 4) != 0 ? false : z16;
        if ((i3 & 8) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, str, Boolean.valueOf(z16), list2, watermarkUserModel, watermarkDateModel, watermarkPoiModelWrapper, byteString, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // com.squareup.wire.Message
    @NotNull
    public Builder newBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Builder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Builder builder = new Builder();
        builder.entityIdList = this.entityIdList;
        builder.dataKey = this.dataKey;
        builder.isEditable = this.isEditable;
        builder.menuTypeList = this.menuTypeList;
        builder.watermarkUserModel = this.watermarkUserModel;
        builder.watermarkDateModel = this.watermarkDateModel;
        builder.watermarkPoiModelWrapper = this.watermarkPoiModelWrapper;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatermarkDataSourceModel(@NotNull List<Long> entityIdList, @NotNull String dataKey, boolean z16, @NotNull List<? extends MenuType> menuTypeList, @Nullable WatermarkUserModel watermarkUserModel, @Nullable WatermarkDateModel watermarkDateModel, @Nullable WatermarkPoiModelWrapper watermarkPoiModelWrapper, @NotNull ByteString unknownFields) {
        super(ADAPTER, unknownFields);
        Intrinsics.checkNotNullParameter(entityIdList, "entityIdList");
        Intrinsics.checkNotNullParameter(dataKey, "dataKey");
        Intrinsics.checkNotNullParameter(menuTypeList, "menuTypeList");
        Intrinsics.checkNotNullParameter(unknownFields, "unknownFields");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, entityIdList, dataKey, Boolean.valueOf(z16), menuTypeList, watermarkUserModel, watermarkDateModel, watermarkPoiModelWrapper, unknownFields);
            return;
        }
        this.dataKey = dataKey;
        this.isEditable = z16;
        this.watermarkUserModel = watermarkUserModel;
        this.watermarkDateModel = watermarkDateModel;
        this.watermarkPoiModelWrapper = watermarkPoiModelWrapper;
        this.entityIdList = Internal.immutableCopyOf("entityIdList", entityIdList);
        this.menuTypeList = Internal.immutableCopyOf("menuTypeList", menuTypeList);
    }
}
