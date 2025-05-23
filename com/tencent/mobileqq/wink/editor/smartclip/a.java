package com.tencent.mobileqq.wink.editor.smartclip;

import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    public static final boolean a(@NotNull MusicInfoWrapper musicInfoWrapper) {
        String str;
        Intrinsics.checkNotNullParameter(musicInfoWrapper, "<this>");
        WinkEditorMusicInfo musicInfo = musicInfoWrapper.getMusicInfo();
        if (musicInfo != null) {
            str = musicInfo.p();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "fakeMid_template_bgm");
    }
}
