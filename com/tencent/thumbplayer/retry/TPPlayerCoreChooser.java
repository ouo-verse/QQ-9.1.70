package com.tencent.thumbplayer.retry;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPPlayerCoreTypeToString;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.selfdev.TPSelfDevPlayer;
import com.tencent.thumbplayer.impl.system.TPSystemClipPlayer;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPPlayerCoreChooser {
    private static final int INVALID_PLAYER_CORE_INDEX = -1;
    private final int[] mPlayerCoreTypes;
    private int mSelectedPlayerCoreIndex;
    private final TPContext mTPContext;

    public TPPlayerCoreChooser(@NonNull TPContext tPContext, @Nullable int[] iArr) {
        reset();
        this.mTPContext = tPContext;
        if (iArr != null && iArr.length != 0) {
            this.mPlayerCoreTypes = iArr;
        } else {
            TPLogUtil.i(tPContext.getLogTag(), "no specified player core types, use default player core types");
            if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
                TPLogUtil.i(tPContext.getLogTag(), "load all libraries success, use self dev player");
                this.mPlayerCoreTypes = new int[]{2};
            } else {
                TPLogUtil.i(tPContext.getLogTag(), "load all libraries failed, use system player");
                this.mPlayerCoreTypes = new int[]{1};
            }
        }
        TPLogUtil.i(tPContext.getLogTag(), "specified player core types:" + buildPlayerCoreTypesString(this.mPlayerCoreTypes));
    }

    @NonNull
    private static String buildPlayerCoreTypesString(@Nullable int[] iArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[");
        if (iArr != null) {
            for (int i3 : iArr) {
                sb5.append(TPPlayerCoreTypeToString.getPlayerCoreName(i3) + ", ");
            }
        }
        sb5.append("]");
        return sb5.toString();
    }

    private ITPInnerPlayer createPlayerCore(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                TPLogUtil.w(this.mTPContext.getLogTag(), "player core:" + TPPlayerCoreTypeToString.getPlayerCoreName(i3) + " is not supported");
            } else {
                try {
                    return new TPSelfDevPlayer(this.mTPContext);
                } catch (TPLoadLibraryException e16) {
                    TPLogUtil.w(this.mTPContext.getLogTag(), "create player core:" + TPPlayerCoreTypeToString.getPlayerCoreName(i3) + " failed with " + e16);
                }
            }
            return null;
        }
        return new TPSystemClipPlayer(this.mTPContext);
    }

    @Nullable
    public ITPInnerPlayer choosePlayerCoreForFirstOpen() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "player core types:" + buildPlayerCoreTypesString(this.mPlayerCoreTypes));
        ITPInnerPlayer iTPInnerPlayer = null;
        int i3 = 0;
        while (true) {
            int[] iArr = this.mPlayerCoreTypes;
            if (i3 >= iArr.length) {
                break;
            }
            this.mSelectedPlayerCoreIndex = i3;
            iTPInnerPlayer = createPlayerCore(iArr[i3]);
            if (iTPInnerPlayer != null) {
                break;
            }
            i3++;
        }
        return iTPInnerPlayer;
    }

    @Nullable
    public ITPInnerPlayer choosePlayerCoreForRetry() {
        TPLogUtil.i(this.mTPContext.getLogTag(), "player core types:" + buildPlayerCoreTypesString(this.mPlayerCoreTypes) + "\uff0cmSelectedPlayerCoreIndex\uff1a" + this.mSelectedPlayerCoreIndex);
        int[] iArr = this.mPlayerCoreTypes;
        ITPInnerPlayer iTPInnerPlayer = null;
        if (iArr != null && iArr.length != 0) {
            int i3 = this.mSelectedPlayerCoreIndex;
            do {
                i3++;
                int[] iArr2 = this.mPlayerCoreTypes;
                if (i3 >= iArr2.length) {
                    break;
                }
                this.mSelectedPlayerCoreIndex = i3;
                iTPInnerPlayer = createPlayerCore(iArr2[i3]);
            } while (iTPInnerPlayer == null);
        }
        return iTPInnerPlayer;
    }

    public ITPInnerPlayer choosePlayerCoreForTargetType(int i3) {
        return createPlayerCore(i3);
    }

    public void reset() {
        this.mSelectedPlayerCoreIndex = -1;
    }
}
