package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class HitRelatedEmojiWordsResult {
    public boolean isHit;

    /* renamed from: msg, reason: collision with root package name */
    public String f359185msg;
    public int result;
    public String word;

    public HitRelatedEmojiWordsResult() {
        this.f359185msg = "";
        this.word = "";
    }

    public boolean getIsHit() {
        return this.isHit;
    }

    public String getMsg() {
        return this.f359185msg;
    }

    public int getResult() {
        return this.result;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "HitRelatedEmojiWordsResult{result=" + this.result + ",msg=" + this.f359185msg + ",isHit=" + this.isHit + ",word=" + this.word + ",}";
    }

    public HitRelatedEmojiWordsResult(int i3, String str, boolean z16, String str2) {
        this.result = i3;
        this.f359185msg = str;
        this.isHit = z16;
        this.word = str2;
    }
}
