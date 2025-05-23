package com.tencent.zplan.meme.action;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.common.utils.d;
import com.tencent.zplan.meme.EngineType;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.c;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.meme.model.MemeRecordParams;
import com.tencent.zplan.meme.model.MemeRecordUserInfo;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010)\u001a\u00020(\u0012\b\b\u0002\u0010.\u001a\u00020-\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000102\u00a2\u0006\u0004\b=\u0010>J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0010\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0015H&J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u001f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u001f8@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#R\u001a\u0010)\u001a\u00020(8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0019\u00103\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00107\u001a\u0004\u0018\u0001028\u0006\u00a2\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106\u00a8\u0006?"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanBaseAction;", "Lcom/tencent/zplan/meme/action/MemeAction;", "", "getSenderUin", "getReceiverUin", "", "isDoubleSpriteTask", "Lcom/tencent/zplan/meme/Meme$Type;", "getType", "uin", "Lcom/tencent/zplan/meme/c;", "listener", "checkResource", "appearanceKey", "isAppearanceKeyMatch", "", "resetRecordKey$record_debug", "(Ljava/lang/String;Ljava/lang/String;)V", "resetRecordKey", "getKey", "genRecordKey", "Lcom/tencent/zplan/meme/model/MemeRecordParams;", "toMemeRecordParams", "", "Lorg/json/JSONObject;", "toPreDownloadParams", "", "frameRate", "I", "getFrameRate", "()I", "Lcom/tencent/zplan/meme/model/d;", "senderInfo$delegate", "Lkotlin/Lazy;", "getSenderInfo", "()Lcom/tencent/zplan/meme/model/d;", "senderInfo", "receiverInfo$delegate", "getReceiverInfo$record_debug", "receiverInfo", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "Lcom/tencent/zplan/common/model/AppTheme;", "getTheme", "()Lcom/tencent/zplan/common/model/AppTheme;", "Lcom/tencent/zplan/meme/model/a;", "senderAvatarCharacterInfo", "Lcom/tencent/zplan/meme/model/a;", "getSenderAvatarCharacterInfo", "()Lcom/tencent/zplan/meme/model/a;", "receiverAvatarCharacterInfo", "getReceiverAvatarCharacterInfo", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "receiverUin", "expectSenderGender", "expectReceiverGender", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/meme/action/MODE;Lcom/tencent/zplan/common/model/AppTheme;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;)V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public abstract class MemeZPlanBaseAction extends MemeAction {
    private final int frameRate;

    @NotNull
    private final MODE mode;

    @Nullable
    private final AvatarCharacterInfo receiverAvatarCharacterInfo;

    /* renamed from: receiverInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy receiverInfo;

    @Nullable
    private final AvatarCharacterInfo senderAvatarCharacterInfo;

    /* renamed from: senderInfo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy senderInfo;

    @NotNull
    private final AppTheme theme;

    public /* synthetic */ MemeZPlanBaseAction(String str, String str2, MODE mode, AppTheme appTheme, Integer num, Integer num2, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, mode, (i3 & 8) != 0 ? AppTheme.DAY : appTheme, (i3 & 16) != 0 ? null : num, (i3 & 32) != 0 ? null : num2, (i3 & 64) != 0 ? null : avatarCharacterInfo, (i3 & 128) != 0 ? null : avatarCharacterInfo2);
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean checkResource(@NotNull String uin, @NotNull c listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return true;
    }

    @NotNull
    public String genRecordKey() {
        JSONObject f16 = getConfig().getCamera().f();
        String str = getSenderInfo().d() + util.base64_pad_url + getReceiverInfo$record_debug().d() + util.base64_pad_url;
        int i3 = getSenderInfo().get_gender();
        int i16 = getReceiverInfo$record_debug().get_gender();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(getWidth());
        sb6.append(util.base64_pad_url);
        sb6.append(getHeight());
        sb6.append(util.base64_pad_url);
        sb5.append(sb6.toString());
        if (f16 != null) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(f16);
            sb7.append(util.base64_pad_url);
            sb5.append(sb7.toString());
        }
        Integer aaType = getConfig().getAaType();
        if (aaType != null) {
            int intValue = aaType.intValue();
            StringBuilder sb8 = new StringBuilder();
            sb8.append(intValue);
            sb8.append(util.base64_pad_url);
            sb5.append(sb8.toString());
        }
        Integer aaLevel = getConfig().getAaLevel();
        if (aaLevel != null) {
            int intValue2 = aaLevel.intValue();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(intValue2);
            sb9.append(util.base64_pad_url);
            sb5.append(sb9.toString());
        }
        if (getConfig().getMp4Config().getCover().getSaveCover()) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(getConfig().getMp4Config().getCover().getCoverIndex());
            sb10.append(util.base64_pad_url);
            sb5.append(sb10.toString());
        }
        String sb11 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb11, "StringBuilder().apply(builderAction).toString()");
        String c16 = d.c(sb11);
        Intrinsics.checkNotNullExpressionValue(c16, "MD5.toMD5(md5Content)");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        if (c16 != null) {
            String lowerCase = c16.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String obj = getMode().toString();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
            if (obj != null) {
                String lowerCase2 = obj.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                String obj2 = getTheme().toString();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
                if (obj2 != null) {
                    String lowerCase3 = obj2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                    return lowerCase + util.base64_pad_url + i3 + util.base64_pad_url + i16 + util.base64_pad_url + lowerCase2 + util.base64_pad_url + lowerCase3;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getKey() {
        if (get_recordKey() == null) {
            set_recordKey(genRecordKey());
        }
        String str = get_recordKey();
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public MODE getMode() {
        return this.mode;
    }

    @Nullable
    public final AvatarCharacterInfo getReceiverAvatarCharacterInfo() {
        return this.receiverAvatarCharacterInfo;
    }

    @NotNull
    public final MemeRecordUserInfo getReceiverInfo$record_debug() {
        return (MemeRecordUserInfo) this.receiverInfo.getValue();
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public String getReceiverUin() {
        return getReceiverInfo$record_debug().getUin();
    }

    @Nullable
    public final AvatarCharacterInfo getSenderAvatarCharacterInfo() {
        return this.senderAvatarCharacterInfo;
    }

    @NotNull
    public final MemeRecordUserInfo getSenderInfo() {
        return (MemeRecordUserInfo) this.senderInfo.getValue();
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @Nullable
    public String getSenderUin() {
        return getSenderInfo().getUin();
    }

    @NotNull
    public AppTheme getTheme() {
        return this.theme;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public Meme.Type getType() {
        if (getConfig().getTargetEngine() instanceof EngineType.Filament) {
            return Meme.Type.Filament;
        }
        return Meme.Type.ZPlan;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean isAppearanceKeyMatch(@NotNull String uin, @NotNull String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        if (getSenderInfo().i(uin, appearanceKey) && getReceiverInfo$record_debug().i(uin, appearanceKey)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public boolean isDoubleSpriteTask() {
        return false;
    }

    @Override // com.tencent.zplan.meme.action.MemeAction
    public void resetRecordKey$record_debug(@NotNull String uin, @NotNull String appearanceKey) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        getSenderInfo().c(uin, appearanceKey);
        getReceiverInfo$record_debug().c(uin, appearanceKey);
        String key = getKey();
        set_recordKey(genRecordKey());
        String key2 = getKey();
        lx4.d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.c(a16, MemeAction.TAG, 1, "resetRecordKey from " + key + " to " + key2, null, 8, null);
        }
    }

    @NotNull
    public abstract MemeRecordParams toMemeRecordParams();

    @NotNull
    public abstract List<JSONObject> toPreDownloadParams();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeZPlanBaseAction(@NotNull final String senderUin, @Nullable final String str, @NotNull MODE mode, @NotNull AppTheme theme, @Nullable final Integer num, @Nullable final Integer num2, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2) {
        super(mode);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(senderUin, "senderUin");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.mode = mode;
        this.theme = theme;
        this.senderAvatarCharacterInfo = avatarCharacterInfo;
        this.receiverAvatarCharacterInfo = avatarCharacterInfo2;
        this.frameRate = Meme.f385754h.k().getFrameRate();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MemeRecordUserInfo>() { // from class: com.tencent.zplan.meme.action.MemeZPlanBaseAction$senderInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemeRecordUserInfo invoke() {
                return new MemeRecordUserInfo(senderUin, num, MemeZPlanBaseAction.this.getSenderAvatarCharacterInfo());
            }
        });
        this.senderInfo = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MemeRecordUserInfo>() { // from class: com.tencent.zplan.meme.action.MemeZPlanBaseAction$receiverInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MemeRecordUserInfo invoke() {
                return new MemeRecordUserInfo(str, num2, MemeZPlanBaseAction.this.getReceiverAvatarCharacterInfo());
            }
        });
        this.receiverInfo = lazy2;
    }
}
