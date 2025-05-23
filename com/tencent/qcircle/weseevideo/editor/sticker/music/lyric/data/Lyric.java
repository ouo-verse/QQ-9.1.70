package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data;

import android.graphics.Paint;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Lyric {
    public static final int LYRIC_TYPE_LRC = 1;
    public static final int LYRIC_TYPE_QRC = 2;
    private static final String TAG = "Lyric";
    private Sentence mLastHitSentence;
    private int mLastHitSentenceNo;

    @Deprecated
    public int mOffset;
    public ArrayList<Sentence> mSentences;
    public int mType;
    public ArrayList<SentenceUI> mListSentenceUI = new ArrayList<>();
    private int mUILineCount = 0;

    public Lyric(int i3, int i16, ArrayList<Sentence> arrayList) {
        this.mType = i3;
        this.mOffset = i16;
        this.mSentences = arrayList;
    }

    public void clear() {
        this.mUILineCount = 0;
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList != null) {
            arrayList.clear();
        }
        ArrayList<SentenceUI> arrayList2 = this.mListSentenceUI;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        this.mLastHitSentence = null;
        this.mLastHitSentenceNo = 0;
    }

    public void copy(Lyric lyric) {
        this.mType = lyric.mType;
        this.mOffset = lyric.mOffset;
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList == null) {
            this.mSentences = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        Iterator<Sentence> it = lyric.mSentences.iterator();
        while (it.hasNext()) {
            this.mSentences.add(it.next().getCopy());
        }
        this.mUILineCount = lyric.getUILineSize();
        Log.d(TAG, "copy -> mType : " + this.mType);
    }

    public int countSentence(int i3, int i16) {
        if (isEmpty()) {
            return 0;
        }
        int findLineNoByStartTime = findLineNoByStartTime(i3);
        int findEndLineByStartTime = findEndLineByStartTime(i16);
        if (findLineNoByStartTime < 0 || findEndLineByStartTime < findLineNoByStartTime) {
            return 0;
        }
        return (findEndLineByStartTime - findLineNoByStartTime) + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        if (r2 != r6) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        r12 = r4.mText;
        r12 = r12.substring(r5.mStart, r12.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        r12 = r4.mText.length();
        r13 = r5.mEnd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
    
        if (r12 < r13) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
    
        r12 = r4.mText.substring(r5.mStart, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r12 = r4.mText;
        r12 = r12.substring(r5.mStart, r12.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a3, code lost:
    
        if (r2 != r6) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a5, code lost:
    
        r12 = r4.mText;
        r12 = r12.substring(r5.mStart, r12.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b2, code lost:
    
        r12 = r4.mText.length();
        r13 = r5.mEnd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ba, code lost:
    
        if (r12 < r13) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00bc, code lost:
    
        r12 = r4.mText.substring(r5.mStart, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c5, code lost:
    
        r12 = r4.mText;
        r12 = r12.substring(r5.mStart, r12.length());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String findCharacterByTime(long j3) {
        int size;
        ArrayList<Sentence> arrayList = this.mSentences;
        LyricCharacter lyricCharacter = null;
        if (arrayList == null || arrayList.isEmpty() || j3 < 0) {
            return null;
        }
        int size2 = this.mSentences.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size2; i16++) {
            Sentence sentence = this.mSentences.get(i16);
            long j16 = sentence.mStartTime;
            if (j3 >= j16 && j3 <= j16 + sentence.mDuration) {
                String str = sentence.mText;
                ArrayList<LyricCharacter> arrayList2 = sentence.mCharacters;
                if (arrayList2 != null && (size = arrayList2.size()) > 0) {
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        LyricCharacter lyricCharacter2 = sentence.mCharacters.get(i3);
                        int i17 = size - 1;
                        if (i3 < i17) {
                            lyricCharacter = sentence.mCharacters.get(i3 + 1);
                        }
                        long j17 = lyricCharacter2.mStartTime;
                        if (j17 <= j3 && lyricCharacter != null && lyricCharacter.mStartTime > j3) {
                            try {
                                break;
                            } catch (StringIndexOutOfBoundsException e16) {
                                e16.printStackTrace();
                            }
                        } else if (j17 <= j3 && j17 + lyricCharacter2.mDuration >= j3) {
                            try {
                                break;
                            } catch (StringIndexOutOfBoundsException e17) {
                                e17.printStackTrace();
                            }
                        } else {
                            i3++;
                        }
                    }
                }
                return str;
            }
        }
        return null;
    }

    public int findEndLineByStartTime(int i3) {
        int i16;
        int i17 = 0;
        if (i3 < 0) {
            Log.w(TAG, "findEndLineByStartTime -> illegal time");
            return 0;
        }
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList == null) {
            Log.w(TAG, "findEndLineByStartTime -> sentence data not found");
            return -1;
        }
        int size = arrayList.size();
        int i18 = 0;
        while (true) {
            if (i18 < size) {
                Sentence sentence = arrayList.get(i18);
                if (sentence != null && i3 <= sentence.mStartTime) {
                    i16 = i18 - 1;
                    break;
                }
                i18++;
            } else {
                i16 = 0;
                break;
            }
        }
        if (i16 >= 0) {
            i17 = i16;
        }
        if (i18 == size) {
            return size - 1;
        }
        return i17;
    }

    public int findLineNo(int i3) {
        return findLineNoByStartTime(i3);
    }

    public int findLineNoByEndTime(int i3) {
        int i16 = 0;
        if (i3 < 0) {
            Log.w(TAG, "findLineNoByEndTime -> illegal time");
            return 0;
        }
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList == null) {
            Log.w(TAG, "findLineNoByEndTime -> sentence data not found");
            return -1;
        }
        int size = arrayList.size();
        int i17 = 0;
        while (true) {
            if (i17 >= size) {
                break;
            }
            Sentence sentence = arrayList.get(i17);
            if (sentence != null && sentence.mStartTime + sentence.mDuration >= i3) {
                i16 = i17;
                break;
            }
            i17++;
        }
        if (i17 == size) {
            return size - 1;
        }
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int findLineNoByStartTime(int i3) {
        int i16;
        int i17;
        if (i3 < 0) {
            Log.w(TAG, "findLineNoByStartTime -> illegal time");
            return -1;
        }
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList != null && arrayList.size() != 0) {
            ArrayList<Sentence> arrayList2 = this.mSentences;
            int size = arrayList2.size();
            Sentence sentence = this.mLastHitSentence;
            int i18 = 0;
            if (sentence != null) {
                long j3 = i3;
                if (sentence.mStartTime < j3) {
                    int i19 = this.mLastHitSentenceNo;
                    if (i19 < size - 1) {
                        if (arrayList2.get(i19 + 1).mStartTime > j3) {
                            return this.mLastHitSentenceNo;
                        }
                        i16 = this.mLastHitSentenceNo;
                        while (true) {
                            if (i16 < size) {
                                Sentence sentence2 = arrayList2.get(i16);
                                if (sentence2 != null && sentence2.mStartTime > i3) {
                                    i17 = i16 - 1;
                                    break;
                                }
                                i16++;
                            } else {
                                i17 = 0;
                                break;
                            }
                        }
                        if (i17 >= 0) {
                            i18 = i17;
                        }
                        if (i16 == size) {
                            i18 = size - 1;
                        }
                        this.mLastHitSentenceNo = i18;
                        this.mLastHitSentence = arrayList2.get(i18);
                        return i18;
                    }
                    return i19;
                }
            }
            i16 = 0;
            while (true) {
                if (i16 < size) {
                }
                i16++;
            }
            if (i17 >= 0) {
            }
            if (i16 == size) {
            }
            this.mLastHitSentenceNo = i18;
            this.mLastHitSentence = arrayList2.get(i18);
            return i18;
        }
        Log.w(TAG, "findLineNoByStartTime -> lyric is empty");
        return -1;
    }

    public String findTextByTime(long j3) {
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList == null || arrayList.isEmpty() || j3 < 0) {
            return null;
        }
        int size = this.mSentences.size();
        for (int i3 = 0; i3 < size; i3++) {
            Sentence sentence = this.mSentences.get(i3);
            long j16 = sentence.mStartTime;
            if (j3 >= j16 && j3 <= j16 + sentence.mDuration) {
                return sentence.mText;
            }
        }
        return null;
    }

    public int floorLineNoByEndTime(int i3) {
        int i16;
        int i17 = 0;
        if (i3 >= 0 && !isEmpty()) {
            ArrayList<Sentence> arrayList = this.mSentences;
            int size = arrayList.size();
            int i18 = 0;
            while (true) {
                if (i18 < size) {
                    Sentence sentence = arrayList.get(i18);
                    if (sentence != null && sentence.mStartTime + sentence.mDuration > i3) {
                        i16 = i18 - 1;
                        break;
                    }
                    i18++;
                } else {
                    i16 = 0;
                    break;
                }
            }
            if (i16 >= 0) {
                i17 = i16;
            }
            if (i18 == size) {
                return size - 1;
            }
            return i17;
        }
        Log.w(TAG, "floorLineNoByEndTime -> illegal time");
        return 0;
    }

    public void generateUiLyricLineList(Paint paint, Paint paint2, int i3) {
        generateUiLyricLineList(paint, paint2, i3, false, false);
    }

    public int getEndTime() {
        if (isEmpty()) {
            return 0;
        }
        Sentence sentence = this.mSentences.get(r0.size() - 1);
        return (int) (sentence.mStartTime + sentence.mDuration);
    }

    public Sentence getSentence(int i3) {
        if (isEmpty() || this.mSentences.size() <= i3) {
            return null;
        }
        return this.mSentences.get(i3);
    }

    public List<Sentence> getSentenceList() {
        return this.mSentences;
    }

    public String getSentenceText(int i3) {
        if (isEmpty() || this.mSentences.size() <= i3) {
            return null;
        }
        return this.mSentences.get(i3).mText;
    }

    public int getStartTime() {
        if (isEmpty()) {
            return 0;
        }
        return (int) this.mSentences.get(0).mStartTime;
    }

    public int[] getTimeArray() {
        if (isEmpty()) {
            return null;
        }
        int size = this.mSentences.size();
        int[] iArr = new int[size * 2];
        for (int i3 = 0; i3 < size; i3++) {
            Sentence sentence = this.mSentences.get(i3);
            if (sentence != null) {
                int i16 = i3 * 2;
                long j3 = sentence.mStartTime;
                iArr[i16] = (int) j3;
                iArr[i16 + 1] = (int) (j3 + sentence.mDuration);
            } else {
                int i17 = i3 * 2;
                iArr[i17] = 0;
                iArr[i17 + 1] = 0;
            }
        }
        return iArr;
    }

    public int getUILineSize() {
        return this.mUILineCount;
    }

    public boolean isEmpty() {
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList != null && arrayList.size() != 0) {
            return false;
        }
        return true;
    }

    public int size() {
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        if (this.mSentences == null) {
            return "";
        }
        for (int i3 = 0; i3 < this.mSentences.size(); i3++) {
            Sentence sentence = this.mSentences.get(i3);
            sb5.append(i3);
            sb5.append(":");
            sb5.append(sentence.mStartTime);
            sb5.append(":");
            sb5.append(sentence.mText);
            sb5.append(":");
            sb5.append(sentence.mDuration + sentence.mStartTime);
            sb5.append("\n");
        }
        return sb5.toString();
    }

    public void generateUiLyricLineList(Paint paint, Paint paint2, int i3, boolean z16) {
        generateUiLyricLineList(paint, paint2, i3, z16, false);
    }

    public void generateUiLyricLineList(Paint paint, Paint paint2, int i3, boolean z16, boolean z17) {
        Log.d(TAG, String.format("generateUiLyricLineList -> width:%d, isSingleLine:%b, isLeftAlign:%b", Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17)));
        this.mListSentenceUI.clear();
        this.mUILineCount = 0;
        ArrayList<Sentence> arrayList = this.mSentences;
        if (arrayList != null) {
            Iterator<Sentence> it = arrayList.iterator();
            while (it.hasNext()) {
                Sentence next = it.next();
                next.generateUILyricLineList(paint, paint2, i3, z16, z17);
                this.mUILineCount += next.getUiLineSize();
                this.mListSentenceUI.addAll(next.mUILine);
            }
        }
    }
}
