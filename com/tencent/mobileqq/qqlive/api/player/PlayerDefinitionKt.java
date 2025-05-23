package com.tencent.mobileqq.qqlive.api.player;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"DEFINITION_KEY", "", "getDefinition", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo$VideoDefinition;", "default", "getDefinitionName", "definitionInfo", "intToDefinition", "level", "", "saveDefinition", "", "definition", "qq-live-sdk-api_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class PlayerDefinitionKt {

    @NotNull
    private static final String DEFINITION_KEY = "USER_SELECT_DEFINITON_LEVEL";

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30521);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[EnterRoomInfo.VideoDefinition.values().length];
            try {
                iArr[EnterRoomInfo.VideoDefinition.ORIGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.FHD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.SD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.HD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.SHD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.THFD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final EnterRoomInfo.VideoDefinition getDefinition(@NotNull EnterRoomInfo.VideoDefinition videoDefinition) {
        Intrinsics.checkNotNullParameter(videoDefinition, "default");
        return intToDefinition(ct3.a.g(DEFINITION_KEY, videoDefinition.level));
    }

    public static /* synthetic */ EnterRoomInfo.VideoDefinition getDefinition$default(EnterRoomInfo.VideoDefinition videoDefinition, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            videoDefinition = EnterRoomInfo.VideoDefinition.FHD;
        }
        return getDefinition(videoDefinition);
    }

    @NotNull
    public static final String getDefinitionName(@Nullable EnterRoomInfo.VideoDefinition videoDefinition) {
        int i3;
        if (videoDefinition == null) {
            i3 = -1;
        } else {
            i3 = WhenMappings.$EnumSwitchMapping$0[videoDefinition.ordinal()];
        }
        switch (i3) {
            case 1:
            case 2:
                return "\u84dd\u5149";
            case 3:
                return "\u6807\u6e05";
            case 4:
                return "\u9ad8\u6e05";
            case 5:
                return "\u8d85\u6e05";
            case 6:
                return "\u8d85\u84dd\u5149";
            default:
                return "\u672a\u77e5";
        }
    }

    @NotNull
    public static final EnterRoomInfo.VideoDefinition intToDefinition(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                return EnterRoomInfo.VideoDefinition.ORIGIN;
                            }
                            return EnterRoomInfo.VideoDefinition.THFD;
                        }
                        return EnterRoomInfo.VideoDefinition.FHD;
                    }
                    return EnterRoomInfo.VideoDefinition.SHD;
                }
                return EnterRoomInfo.VideoDefinition.HD;
            }
            return EnterRoomInfo.VideoDefinition.SD;
        }
        return EnterRoomInfo.VideoDefinition.ORIGIN;
    }

    public static final void saveDefinition(@NotNull EnterRoomInfo.VideoDefinition definition) {
        Intrinsics.checkNotNullParameter(definition, "definition");
        ct3.a.p(DEFINITION_KEY, definition.level);
    }
}
