package com.tencent.qqguild.directmessage.aio.input;

import android.content.res.Configuration;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.guild.util.ay;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGuildSpeakableThresholdPermission;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u000e\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\r\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "<init>", "()V", "d", "AddEmoticonUIState", "ClearEditInputUIState", "a", "ConfigurationChanged", "DirectMessageSwitch", "GuildHandlerPermissionsChange", "GuildUpdateSpeakThresholdChange", "HidePanelAndKeyboardUIState", "HintTextUIState", "MultiSelectChanged", "RecoverDraft", "RefreshSendBtn", "ReplyUIState", "ShowSoftKeyboard", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$AddEmoticonUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$ClearEditInputUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$ConfigurationChanged;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$DirectMessageSwitch;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$GuildHandlerPermissionsChange;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$GuildUpdateSpeakThresholdChange;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$HidePanelAndKeyboardUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$HintTextUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$MultiSelectChanged;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$RecoverDraft;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$RefreshSendBtn;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$ReplyUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState$ShowSoftKeyboard;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class UIState implements InputUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final List<Class<? extends UIState>> f345028e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$AddEmoticonUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "emoticonCode", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class AddEmoticonUIState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String emoticonCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddEmoticonUIState(@NotNull String emoticonCode) {
            super(null);
            Intrinsics.checkNotNullParameter(emoticonCode, "emoticonCode");
            this.emoticonCode = emoticonCode;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getEmoticonCode() {
            return this.emoticonCode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof AddEmoticonUIState) && Intrinsics.areEqual(this.emoticonCode, ((AddEmoticonUIState) other).emoticonCode)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.emoticonCode.hashCode();
        }

        @NotNull
        public String toString() {
            return "AddEmoticonUIState(emoticonCode=" + this.emoticonCode + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$ClearEditInputUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "()V", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class ClearEditInputUIState extends UIState {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final ClearEditInputUIState f345030f = new ClearEditInputUIState();

        ClearEditInputUIState() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "ClearEditInputUIState";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$ConfigurationChanged;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "Landroid/content/res/Configuration;", "f", "Landroid/content/res/Configuration;", "getNewConfig", "()Landroid/content/res/Configuration;", "newConfig", "<init>", "(Landroid/content/res/Configuration;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class ConfigurationChanged extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Configuration newConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfigurationChanged(@NotNull Configuration newConfig) {
            super(null);
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            this.newConfig = newConfig;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$DirectMessageSwitch;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Z", "b", "()Z", "enable", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class DirectMessageSwitch extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        public DirectMessageSwitch(boolean z16) {
            super(null);
            this.enable = z16;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DirectMessageSwitch) && this.enable == ((DirectMessageSwitch) other).enable) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.enable;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "DirectMessageSwitch(enable=" + this.enable + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$GuildHandlerPermissionsChange;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "I", "b", "()I", "permissions", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class GuildHandlerPermissionsChange extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int permissions;

        public GuildHandlerPermissionsChange(int i3) {
            super(null);
            this.permissions = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GuildHandlerPermissionsChange) && this.permissions == ((GuildHandlerPermissionsChange) other).permissions) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.permissions;
        }

        @NotNull
        public String toString() {
            return "GuildHandlerPermissionsChange(permissions=" + this.permissions + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$GuildUpdateSpeakThresholdChange;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "I", "d", "()I", "permissions", h.F, "Z", "e", "()Z", "isSelectMode", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "i", "Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;", "limit", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "<init>", "(IZLcom/tencent/mobileqq/qqguildsdk/data/IGuildSpeakableThresholdPermission;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class GuildUpdateSpeakThresholdChange extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int permissions;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelectMode;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final IGuildSpeakableThresholdPermission limit;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildUpdateSpeakThresholdChange(int i3, boolean z16, @NotNull IGuildSpeakableThresholdPermission limit, @NotNull String guildId) {
            super(null);
            Intrinsics.checkNotNullParameter(limit, "limit");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.permissions = i3;
            this.isSelectMode = z16;
            this.limit = limit;
            this.guildId = guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final IGuildSpeakableThresholdPermission getLimit() {
            return this.limit;
        }

        /* renamed from: d, reason: from getter */
        public final int getPermissions() {
            return this.permissions;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsSelectMode() {
            return this.isSelectMode;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildUpdateSpeakThresholdChange)) {
                return false;
            }
            GuildUpdateSpeakThresholdChange guildUpdateSpeakThresholdChange = (GuildUpdateSpeakThresholdChange) other;
            if (this.permissions == guildUpdateSpeakThresholdChange.permissions && this.isSelectMode == guildUpdateSpeakThresholdChange.isSelectMode && Intrinsics.areEqual(this.limit, guildUpdateSpeakThresholdChange.limit) && Intrinsics.areEqual(this.guildId, guildUpdateSpeakThresholdChange.guildId)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.permissions * 31;
            boolean z16 = this.isSelectMode;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return ((((i3 + i16) * 31) + this.limit.hashCode()) * 31) + this.guildId.hashCode();
        }

        @NotNull
        public String toString() {
            return "GuildUpdateSpeakThresholdChange(permissions=" + this.permissions + ", isSelectMode=" + this.isSelectMode + ", limit=" + this.limit + ", guildId=" + this.guildId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$HidePanelAndKeyboardUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "()V", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class HidePanelAndKeyboardUIState extends UIState {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final HidePanelAndKeyboardUIState f345038f = new HidePanelAndKeyboardUIState();

        HidePanelAndKeyboardUIState() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "HidePanelAndKeyboardUIState";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$HintTextUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "nickName", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class HintTextUIState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String nickName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HintTextUIState(@NotNull String nickName) {
            super(null);
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            this.nickName = nickName;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof HintTextUIState) && Intrinsics.areEqual(this.nickName, ((HintTextUIState) other).nickName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.nickName.hashCode();
        }

        @NotNull
        public String toString() {
            return "HintTextUIState(nickName='" + ay.a(this.nickName) + "')";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$MultiSelectChanged;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "f", "Z", "c", "()Z", "enable", h.F, "I", "b", "()I", "count", "i", "d", "fromJubao", "<init>", "(ZIZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class MultiSelectChanged extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean enable;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean fromJubao;

        public MultiSelectChanged(boolean z16, int i3, boolean z17) {
            super(null);
            this.enable = z16;
            this.count = i3;
            this.fromJubao = z17;
        }

        /* renamed from: b, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnable() {
            return this.enable;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getFromJubao() {
            return this.fromJubao;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiSelectChanged)) {
                return false;
            }
            MultiSelectChanged multiSelectChanged = (MultiSelectChanged) other;
            if (this.enable == multiSelectChanged.enable && this.count == multiSelectChanged.count && this.fromJubao == multiSelectChanged.fromJubao) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.enable;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = ((r06 * 31) + this.count) * 31;
            boolean z17 = this.fromJubao;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "MultiSelectChanged(enable=" + this.enable + ", count=" + this.count + ", fromJubao=" + this.fromJubao + ")";
        }

        public /* synthetic */ MultiSelectChanged(boolean z16, int i3, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(z16, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? false : z17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$RecoverDraft;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "f", "Ljava/util/List;", "b", "()Ljava/util/List;", "msgElements", "", h.F, "Z", "c", "()Z", "showKeyboard", "<init>", "(Ljava/util/List;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class RecoverDraft extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<MsgElement> msgElements;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean showKeyboard;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecoverDraft(@NotNull List<MsgElement> msgElements, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(msgElements, "msgElements");
            this.msgElements = msgElements;
            this.showKeyboard = z16;
        }

        @NotNull
        public final List<MsgElement> b() {
            return this.msgElements;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getShowKeyboard() {
            return this.showKeyboard;
        }

        public /* synthetic */ RecoverDraft(List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i3 & 2) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$RefreshSendBtn;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "f", "I", "b", "()I", "selectedMediaCount", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class RefreshSendBtn extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int selectedMediaCount;

        public RefreshSendBtn(int i3) {
            super(null);
            this.selectedMediaCount = i3;
        }

        /* renamed from: b, reason: from getter */
        public final int getSelectedMediaCount() {
            return this.selectedMediaCount;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$ReplyUIState;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "f", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "text", h.F, "Z", "c", "()Z", NodeProps.VISIBLE, "<init>", "(Ljava/lang/CharSequence;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class ReplyUIState extends UIState {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final CharSequence text;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean visible;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReplyUIState(@NotNull CharSequence text, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.visible = z16;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReplyUIState)) {
                return false;
            }
            ReplyUIState replyUIState = (ReplyUIState) other;
            if (Intrinsics.areEqual(this.text, replyUIState.text) && this.visible == replyUIState.visible) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.text.hashCode() * 31;
            boolean z16 = this.visible;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            CharSequence charSequence = this.text;
            return "ReplyUIState(text=" + ((Object) charSequence) + ", visible=" + this.visible + ")";
        }

        public /* synthetic */ ReplyUIState(CharSequence charSequence, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, (i3 & 2) != 0 ? true : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$ShowSoftKeyboard;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "()V", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class ShowSoftKeyboard extends UIState {

        /* renamed from: f, reason: collision with root package name */
        @NotNull
        public static final ShowSoftKeyboard f345048f = new ShowSoftKeyboard();

        ShowSoftKeyboard() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "ShowSoftKeyboard";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR%\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/input/UIState$a;", "", "", "Ljava/lang/Class;", "Lcom/tencent/qqguild/directmessage/aio/input/UIState;", "subClasses", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqguild.directmessage.aio.input.UIState$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Class<? extends UIState>> a() {
            return UIState.f345028e;
        }

        Companion() {
        }
    }

    static {
        List<Class<? extends UIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{HidePanelAndKeyboardUIState.class, ClearEditInputUIState.class, ShowSoftKeyboard.class, AddEmoticonUIState.class, DirectMessageSwitch.class, HintTextUIState.class, ReplyUIState.class, GuildHandlerPermissionsChange.class, GuildUpdateSpeakThresholdChange.class, MultiSelectChanged.class, RecoverDraft.class, RefreshSendBtn.class});
        f345028e = listOf;
    }

    public /* synthetic */ UIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    UIState() {
    }
}
