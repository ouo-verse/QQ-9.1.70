package com.tencent.zplan.meme.action;

import androidx.annotation.Keep;
import com.tencent.zplan.common.model.AppTheme;
import com.tencent.zplan.common.utils.d;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0093\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 \u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\f\u001a\u00020\u000b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\"\u0004\b\u0016\u0010\u0017\u00a8\u0006&"}, d2 = {"Lcom/tencent/zplan/meme/action/MemeZPlanEmoticon2DAction;", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "", "genRecordKey", "", "width", "I", "getWidth", "()I", "height", "getHeight", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "Lcom/tencent/zplan/meme/action/MODE;", "getMode", "()Lcom/tencent/zplan/meme/action/MODE;", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "url", "getUrl", "setUrl", "(Ljava/lang/String;)V", "portraitId", "frameCount", "sender", "receiver", "Lcom/tencent/zplan/common/model/AppTheme;", "theme", "senderGender", "receiverGender", "Lcom/tencent/zplan/meme/model/a;", "senderAvatarCharacterInfo", "receiverAvatarCharacterInfo", "<init>", "(IIIILcom/tencent/zplan/meme/action/MODE;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/common/model/AppTheme;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tencent/zplan/meme/model/a;Lcom/tencent/zplan/meme/model/a;)V", "Companion", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeZPlanEmoticon2DAction extends MemeZPlanAction {

    @NotNull
    public static final String TAG = "[zplan][MemePlayer-Action][MemeZPlanEmoticon2DAction]";
    private final int height;

    @NotNull
    private final MODE mode;

    @NotNull
    private final String name;

    @Nullable
    private String url;
    private final int width;

    public /* synthetic */ MemeZPlanEmoticon2DAction(int i3, int i16, int i17, int i18, MODE mode, String str, String str2, String str3, AppTheme appTheme, String str4, Integer num, Integer num2, AvatarCharacterInfo avatarCharacterInfo, AvatarCharacterInfo avatarCharacterInfo2, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, mode, (i19 & 32) != 0 ? "" : str, (i19 & 64) != 0 ? null : str2, str3, (i19 & 256) != 0 ? AppTheme.DAY : appTheme, (i19 & 512) != 0 ? null : str4, (i19 & 1024) != 0 ? null : num, (i19 & 2048) != 0 ? null : num2, (i19 & 4096) != 0 ? null : avatarCharacterInfo, (i19 & 8192) != 0 ? null : avatarCharacterInfo2);
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanAction, com.tencent.zplan.meme.action.MemeZPlanBaseAction
    @NotNull
    public String genRecordKey() {
        String c16 = d.c(super.genRecordKey() + util.base64_pad_url + this.url);
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
                    return lowerCase + util.base64_pad_url + getSenderInfo().get_gender() + util.base64_pad_url + getReceiverInfo$record_debug().get_gender() + util.base64_pad_url + lowerCase2 + util.base64_pad_url + lowerCase3 + util.base64_pad_url + getPortraitId();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanAction, com.tencent.zplan.meme.action.MemeAction
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanAction, com.tencent.zplan.meme.action.MemeZPlanBaseAction, com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public MODE getMode() {
        return this.mode;
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanAction, com.tencent.zplan.meme.action.MemeAction
    @NotNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Override // com.tencent.zplan.meme.action.MemeZPlanAction, com.tencent.zplan.meme.action.MemeAction
    public int getWidth() {
        return this.width;
    }

    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemeZPlanEmoticon2DAction(int i3, int i16, int i17, int i18, @NotNull MODE mode, @NotNull String sender, @Nullable String str, @NotNull String name, @NotNull AppTheme theme, @Nullable String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable AvatarCharacterInfo avatarCharacterInfo2) {
        super(i3, i16, i17, i18, mode, sender, str, name, theme, num, num2, avatarCharacterInfo, avatarCharacterInfo2, null, 8192, null);
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(sender, "sender");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.width = i17;
        this.height = i18;
        this.mode = mode;
        this.name = name;
        this.url = str2;
    }
}
