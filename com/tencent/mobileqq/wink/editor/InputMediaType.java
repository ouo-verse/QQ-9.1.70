package com.tencent.mobileqq.wink.editor;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "COMPRESS", "ORIGIN", "FACE_CROP", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum InputMediaType {
    COMPRESS(ITroopAnnouncementHelperApi.CONTROL_INFO_COMPRESS),
    ORIGIN(TtmlNode.ATTR_TTS_ORIGIN),
    FACE_CROP("faceCrop");


    @NotNull
    private final String type;

    InputMediaType(String str) {
        this.type = str;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
