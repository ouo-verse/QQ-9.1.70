package com.tencent.mobileqq.wink.editor.smartclip;

import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/smartclip/o;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "musicInfo", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o f321529a = new o();

    o() {
    }

    public final boolean a(@Nullable MusicInfoWrapper musicInfo) {
        String str;
        boolean z16;
        WinkEditorMusicInfo musicInfo2;
        com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a aVar = com.tencent.mobileqq.wink.editor.smartclip.viewmodel.a.f321532a;
        if (musicInfo != null && (musicInfo2 = musicInfo.getMusicInfo()) != null) {
            str = musicInfo2.p();
        } else {
            str = null;
        }
        if (aVar.d(str) == null) {
            if (musicInfo != null) {
                z16 = a.a(musicInfo);
            } else {
                z16 = false;
            }
            if (!z16 || aVar.c() == null) {
                return false;
            }
        }
        return true;
    }
}
