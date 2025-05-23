package com.tencent.mobileqq.emoticon.data.api;

import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/ClassicFaceList;", "", "()V", "aniStickerList", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "Lkotlin/collections/ArrayList;", "getAniStickerList", "()Ljava/util/ArrayList;", "emojiList", "getEmojiList", "recentList", "getRecentList", "sysFaceList", "getSysFaceList", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class ClassicFaceList {
    static IPatchRedirector $redirector_;

    @NotNull
    private final ArrayList<EmoticonInfo> aniStickerList;

    @NotNull
    private final ArrayList<EmoticonInfo> emojiList;

    @NotNull
    private final ArrayList<EmoticonInfo> recentList;

    @NotNull
    private final ArrayList<EmoticonInfo> sysFaceList;

    public ClassicFaceList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.recentList = new ArrayList<>();
        this.aniStickerList = new ArrayList<>();
        this.sysFaceList = new ArrayList<>();
        this.emojiList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<EmoticonInfo> getAniStickerList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.aniStickerList;
    }

    @NotNull
    public final ArrayList<EmoticonInfo> getEmojiList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emojiList;
    }

    @NotNull
    public final ArrayList<EmoticonInfo> getRecentList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.recentList;
    }

    @NotNull
    public final ArrayList<EmoticonInfo> getSysFaceList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.sysFaceList;
    }
}
