package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Paint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Sentence {
    private static final String TAG = "Sentence";
    public ArrayList<LyricCharacter> mCharacters;
    public long mDuration;
    public long mStartTime;
    public String mText;
    public ArrayList<LyricCharacter> mUICharacters;
    public ArrayList<SentenceUI> mUILine = new ArrayList<>();
    public SentenceAttachInfo mNormalLeftAttachInfo = null;
    public SentenceAttachInfo mBitmapLeftAttachInfo = null;

    public Sentence() {
    }

    private boolean isInCharacter(LyricCharacter lyricCharacter, LyricCharacter lyricCharacter2) {
        if (lyricCharacter2.mStart >= lyricCharacter.mStart && lyricCharacter2.mEnd <= lyricCharacter.mEnd) {
            return true;
        }
        return false;
    }

    private ArrayList<LyricCharacter> rerangeLyricCharacterList(String str, String[] strArr, ArrayList<LyricCharacter> arrayList) {
        int i3;
        int i16;
        Iterator<LyricCharacter> it;
        int i17;
        int i18;
        int i19;
        int indexOf;
        int i26;
        int i27 = 1;
        if (strArr.length == 1) {
            return arrayList;
        }
        ArrayList<LyricCharacter> arrayList2 = new ArrayList<>();
        Iterator<LyricCharacter> it5 = arrayList.iterator();
        int i28 = 0;
        int i29 = 0;
        int i36 = 0;
        int i37 = 0;
        while (it5.hasNext()) {
            LyricCharacter next = it5.next();
            if (i28 <= next.mStart) {
                if (i29 == strArr.length - i27) {
                    i3 = this.mText.length();
                } else {
                    i36 += strArr[i29].length();
                    i29++;
                    i3 = str.indexOf(strArr[i29], i36);
                }
            } else {
                int i38 = i37;
                i3 = i28;
                i28 = i38;
            }
            if (next.mStart >= i28 && i3 >= next.mEnd) {
                arrayList2.add(next);
                it = it5;
                i16 = i3;
                i37 = i28;
                i19 = i27;
            } else {
                i16 = i3;
                LyricCharacter lyricCharacter = next;
                while (true) {
                    int i39 = lyricCharacter.mStart;
                    if (i39 < i16 && (i26 = lyricCharacter.mEnd) > i16) {
                        long j3 = ((((float) lyricCharacter.mDuration) * 1.0f) * (i16 - i39)) / (i26 - i39);
                        it = it5;
                        i17 = i28;
                        LyricCharacter lyricCharacter2 = lyricCharacter;
                        i18 = i16;
                        LyricCharacter lyricCharacter3 = new LyricCharacter(lyricCharacter.mStartTime, j3, i39, i16);
                        LyricCharacter lyricCharacter4 = new LyricCharacter(lyricCharacter2.mStartTime + j3, lyricCharacter2.mDuration - j3, i18, lyricCharacter2.mEnd);
                        arrayList2.add(lyricCharacter3);
                        lyricCharacter = lyricCharacter4;
                    } else {
                        it = it5;
                        i17 = i28;
                        i18 = i16;
                        lyricCharacter = lyricCharacter;
                    }
                    if (i18 < lyricCharacter.mEnd) {
                        i19 = 1;
                        if (i29 == strArr.length - 1) {
                            indexOf = this.mText.length();
                        } else {
                            i36 += strArr[i29].length();
                            i29++;
                            indexOf = str.indexOf(strArr[i29], i36);
                        }
                        i16 = indexOf;
                    } else {
                        i19 = 1;
                        i16 = i18;
                        i18 = i17;
                    }
                    if (i16 >= lyricCharacter.mEnd) {
                        break;
                    }
                    it5 = it;
                    i28 = i18;
                }
                arrayList2.add(lyricCharacter);
                i37 = i18;
            }
            it5 = it;
            i27 = i19;
            i28 = i16;
        }
        return arrayList2;
    }

    public void generateUILyricLineList(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        ArrayList<LyricCharacter> arrayList;
        int i16;
        ArrayList<LyricCharacter> arrayList2;
        ArrayList arrayList3;
        Sentence sentence;
        SentenceUI sentenceUI;
        int i17;
        Sentence sentence2 = this;
        Paint paint3 = paint;
        Paint paint4 = paint2;
        int i18 = i3;
        if (TextUtils.isEmpty(sentence2.mText)) {
            return;
        }
        sentence2.mUILine.clear();
        int measureText = (int) paint3.measureText(sentence2.mText);
        int i19 = 0;
        if (measureText <= i18) {
            if (!z17) {
                i19 = (i18 - ((int) paint4.measureText(sentence2.mText))) >> 1;
                i17 = (i18 - measureText) >> 1;
            } else {
                i17 = 0;
            }
            SentenceUI sentenceUI2 = new SentenceUI(sentence2.mText, i19, i17, sentence2.mCharacters);
            SentenceAttachInfo sentenceAttachInfo = sentence2.mBitmapLeftAttachInfo;
            if (sentenceAttachInfo != null) {
                sentenceUI2.mLeftAttachInfo = sentenceAttachInfo;
            } else {
                sentenceUI2.mLeftAttachInfo = sentence2.mNormalLeftAttachInfo;
            }
            sentence2.mUILine.add(sentenceUI2);
        } else if (z16) {
            SentenceUI sentenceUI3 = new SentenceUI(sentence2.mText, 0, 0, sentence2.mCharacters);
            SentenceAttachInfo sentenceAttachInfo2 = sentence2.mBitmapLeftAttachInfo;
            if (sentenceAttachInfo2 != null) {
                sentenceUI3.mLeftAttachInfo = sentenceAttachInfo2;
            } else {
                sentenceUI3.mLeftAttachInfo = sentence2.mNormalLeftAttachInfo;
            }
            sentence2.mUILine.add(sentenceUI3);
        } else {
            String[] wrap = LyricDataUtil.wrap(sentence2.mText, paint3, i18, i18);
            int length = wrap.length;
            if (length > 0) {
                ArrayList<LyricCharacter> arrayList4 = sentence2.mCharacters;
                if (arrayList4 != null) {
                    arrayList = sentence2.rerangeLyricCharacterList(sentence2.mText, wrap, arrayList4);
                    sentence2.mUICharacters = arrayList;
                } else {
                    arrayList = null;
                }
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                while (i19 < length) {
                    String str = wrap[i19];
                    int length2 = str.length();
                    if (!z17) {
                        i37 = (i18 - ((int) paint4.measureText(str))) >> 1;
                        i38 = (i18 - ((int) paint3.measureText(str))) >> 1;
                    }
                    if (arrayList != null) {
                        i26 += length2;
                        arrayList3 = new ArrayList();
                        while (true) {
                            if (i27 < arrayList.size()) {
                                LyricCharacter lyricCharacter = arrayList.get(i27);
                                if (i19 != 0 && i28 == i27) {
                                    int i39 = i26 - length2;
                                    i36 = i39;
                                    i29 = lyricCharacter.mStart - i39;
                                }
                                int i46 = lyricCharacter.mStart;
                                if (i46 <= i26 && lyricCharacter.mEnd >= i26) {
                                    if (i19 == 0) {
                                        i16 = length;
                                        arrayList2 = arrayList;
                                        arrayList3.add(new LyricCharacter(lyricCharacter.mStartTime, lyricCharacter.mDuration, i46, length2));
                                    } else {
                                        i16 = length;
                                        arrayList2 = arrayList;
                                        arrayList3.add(new LyricCharacter(lyricCharacter.mStartTime, lyricCharacter.mDuration, (i46 - i36) - i29, length2));
                                    }
                                    i27++;
                                    i28 = i27;
                                } else {
                                    int i47 = length;
                                    ArrayList<LyricCharacter> arrayList5 = arrayList;
                                    if (i19 == 0) {
                                        arrayList3.add(lyricCharacter);
                                    } else {
                                        arrayList3.add(new LyricCharacter(lyricCharacter.mStartTime, lyricCharacter.mDuration, (i46 - i36) - i29, (lyricCharacter.mEnd - i36) - i29));
                                    }
                                    i27++;
                                    length = i47;
                                    arrayList = arrayList5;
                                }
                            } else {
                                i16 = length;
                                arrayList2 = arrayList;
                                break;
                            }
                        }
                    } else {
                        i16 = length;
                        arrayList2 = arrayList;
                        arrayList3 = null;
                    }
                    if (i19 == 0) {
                        sentenceUI = new SentenceUI(wrap[i19], i37, i38, arrayList3);
                        sentence = this;
                        sentenceUI.mLeftAttachInfo = sentence.mBitmapLeftAttachInfo;
                    } else {
                        sentence = this;
                        sentenceUI = new SentenceUI(wrap[i19], i37, i38, arrayList3);
                        sentenceUI.mLeftAttachInfo = sentence.mNormalLeftAttachInfo;
                    }
                    sentence.mUILine.add(sentenceUI);
                    i19++;
                    paint4 = paint2;
                    i18 = i3;
                    sentence2 = sentence;
                    length = i16;
                    arrayList = arrayList2;
                    paint3 = paint;
                }
            }
        }
    }

    public Sentence getCopy() {
        Sentence sentence = new Sentence();
        sentence.mText = this.mText;
        sentence.mDuration = this.mDuration;
        sentence.mStartTime = this.mStartTime;
        if (this.mCharacters != null) {
            ArrayList<LyricCharacter> arrayList = new ArrayList<>();
            sentence.mCharacters = arrayList;
            arrayList.addAll(this.mCharacters);
        }
        sentence.mUILine.addAll(this.mUILine);
        return sentence;
    }

    public ArrayList<SentenceUI> getUILyricLineList() {
        return this.mUILine;
    }

    public int getUiLineSize() {
        return this.mUILine.size();
    }

    public int[] marshalMarkCharacter(int[] iArr) {
        ArrayList<LyricCharacter> arrayList = this.mUICharacters;
        if (arrayList == null) {
            return iArr;
        }
        int[] iArr2 = new int[arrayList.size()];
        int i3 = 0;
        for (int i16 = 0; i16 < this.mCharacters.size(); i16++) {
            LyricCharacter lyricCharacter = this.mCharacters.get(i16);
            while (i3 < this.mUICharacters.size() && isInCharacter(lyricCharacter, this.mUICharacters.get(i3))) {
                iArr2[i3] = iArr[i16];
                i3++;
            }
        }
        return iArr2;
    }

    public Sentence(SentenceUI sentenceUI) {
        if (sentenceUI == null) {
            return;
        }
        this.mText = sentenceUI.mText;
        this.mCharacters = sentenceUI.mCharacters;
        this.mStartTime = sentenceUI.getStartTime();
        this.mDuration = sentenceUI.getEndTime() - sentenceUI.getStartTime();
    }
}
