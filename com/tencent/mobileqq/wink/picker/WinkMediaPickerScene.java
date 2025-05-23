package com.tencent.mobileqq.wink.picker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "", "desc", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getCode", "()I", "getDesc", "()Ljava/lang/String;", "Universal", "QVideo", "QZone", "Inspiration", "MagicAvatar", "QVideoAvatar", "MagicStudio", "AIEliminate", "ZShow", "Single", "Flock", "QVideoDefault", "QZoneAlbum", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum WinkMediaPickerScene {
    Universal("\u901a\u7528\u9009\u56fe\u9875", -1),
    QVideo("\u77ed\u89c6\u9891\u9009\u56fe\u9875", 0),
    QZone("\u7a7a\u95f4\u9009\u56fe\u9875", 1),
    Inspiration("\u7075\u611f\u5e93\u9009\u56fe\u9875", 2),
    MagicAvatar("\u9b54\u6cd5\u5934\u50cf\u9009\u56fe\u9875", 3),
    QVideoAvatar("\u77ed\u89c6\u9891\u5934\u50cf\u9009\u56fe\u9875", 4),
    MagicStudio("\u9b54\u6cd5\u753b\u5ba4\u9009\u56fe\u9875", 5),
    AIEliminate("AI\u6d88\u9664\u9009\u56fe\u9875", 8),
    ZShow("\u5fc3\u60c5\u65e5\u8bb0\u9009\u56fe\u9875", 9),
    Single("\u5355\u9009\u9009\u56fe\u9875", 10),
    Flock("\u642d\u5b50\u9009\u56fe\u9875", 11),
    QVideoDefault("\u77ed\u89c6\u9891\u9ed8\u8ba4\u9009\u56fe\u9875", 12),
    QZoneAlbum("\u7a7a\u95f4\u76f8\u518c\u9009\u56fe\u9875", 13);

    private final int code;

    @NotNull
    private final String desc;

    WinkMediaPickerScene(String str, int i3) {
        this.desc = str;
        this.code = i3;
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }
}
