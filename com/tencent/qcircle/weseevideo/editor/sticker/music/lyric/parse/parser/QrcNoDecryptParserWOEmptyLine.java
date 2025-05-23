package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.LyricCharacter;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Sentence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes22.dex */
public class QrcNoDecryptParserWOEmptyLine implements IParser {
    private static final String OFFSET_TAG = "offset";
    private static final String QRC_XML_END = "/>";
    private static final String QRC_XML_KEY = "LyricContent";
    private static final String QRC_XML_LINK = "=";
    private static final String QRC_XML_MARK = "\"";
    public static final String TAG = "QrcNoDecParWEmptyLine";
    private ArrayList<Sentence> mLineLyricList = new ArrayList<>();
    private int mOffset;
    private String mString;
    private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
    private static final Pattern mPatternForQrc = Pattern.compile("(?<=\\()-?[0-9]*,-?[0-9]*(?=\\))");
    private static final LyricComparator mLineComparator = new LyricComparator();

    /* loaded from: classes22.dex */
    private static class LyricComparator implements Comparator<Sentence>, Serializable {
        LyricComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Sentence sentence, Sentence sentence2) {
            return sentence.mStartTime >= sentence2.mStartTime ? 1 : -1;
        }
    }

    private int parseOffset(String str) {
        String[] split = str.split("\\:");
        try {
            if (split.length == 2 && "offset".equalsIgnoreCase(split[0])) {
                return Integer.parseInt(split[1].trim());
            }
        } catch (Exception e16) {
            Log.e(TAG, e16.toString());
        }
        return 0;
    }

    private void parseQrcLine(String str) {
        if (str != null && str.length() != 0) {
            Matcher matcher = mPattern.matcher(str);
            ArrayList arrayList = new ArrayList();
            int i3 = -1;
            int i16 = -1;
            while (matcher.find()) {
                String group = matcher.group();
                if (group == null) {
                    group = "";
                }
                int indexOf = str.indexOf("[" + group + "]");
                if (i16 != -1 && indexOf - i16 > i3 + 2) {
                    String substring = str.substring(i16 + i3 + 2, indexOf);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        Sentence sentence = new Sentence();
                        if (parseTimeForQrc(str2, sentence) != -1) {
                            parseQrcWord(substring, sentence);
                            this.mLineLyricList.add(sentence);
                        }
                    }
                    arrayList.clear();
                }
                arrayList.add(group);
                i3 = group.length();
                i16 = indexOf;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            int i17 = i3 + 2 + i16;
            try {
                if (i17 > str.length()) {
                    i17 = str.length();
                }
                String trim = str.substring(i17).trim();
                if (trim.length() == 0 && this.mOffset == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        int parseOffset = parseOffset((String) it5.next());
                        if (parseOffset != Integer.MAX_VALUE) {
                            this.mOffset = parseOffset;
                            return;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    String str3 = (String) it6.next();
                    Sentence sentence2 = new Sentence();
                    if (parseTimeForQrc(str3, sentence2) != -1) {
                        parseQrcWord(trim, sentence2);
                        this.mLineLyricList.add(sentence2);
                    }
                }
            } catch (Exception e16) {
                Log.e(TAG, e16.toString());
            }
        }
    }

    private void parseQrcWord(String str, Sentence sentence) {
        LyricCharacter lyricCharacter;
        try {
            sentence.mText = "";
            if (str != null && str.length() != 0) {
                Matcher matcher = mPatternForQrc.matcher(str);
                StringBuilder sb5 = new StringBuilder();
                ArrayList<LyricCharacter> arrayList = new ArrayList<>();
                while (matcher.find()) {
                    String group = matcher.group();
                    if (group == null) {
                        group = "";
                    }
                    int indexOf = str.indexOf("(" + group + ")");
                    int length = sb5.length();
                    sb5.append(str.substring(0, indexOf));
                    str = str.substring(indexOf + group.length() + 2, str.length());
                    if (arrayList.size() > 0) {
                        lyricCharacter = arrayList.get(arrayList.size() - 1);
                    } else {
                        lyricCharacter = null;
                    }
                    LyricCharacter parseWordTimeForQrc = parseWordTimeForQrc(group, length, sb5.length(), lyricCharacter);
                    if (parseWordTimeForQrc != null) {
                        arrayList.add(parseWordTimeForQrc);
                    }
                }
                sentence.mText = sb5.toString();
                sentence.mCharacters = arrayList;
            }
        } catch (Exception e16) {
            Log.e(TAG, "", e16);
        }
    }

    private long parseTimeForQrc(String str, Sentence sentence) {
        String[] split = str.split("\\,");
        if (split.length < 2) {
            String[] split2 = str.split("\\:");
            if (this.mOffset == 0 && split2[0].equalsIgnoreCase("offset")) {
                this.mOffset = Integer.parseInt(split2[1]);
            }
            return -1L;
        }
        if (split.length == 2) {
            try {
                long parseLong = Long.parseLong(split[1]);
                long parseLong2 = Long.parseLong(split[0]);
                sentence.mDuration = parseLong;
                sentence.mStartTime = parseLong2;
                return parseLong2;
            } catch (Exception unused) {
            }
        }
        return -1L;
    }

    private LyricCharacter parseWordTimeForQrc(String str, int i3, int i16, LyricCharacter lyricCharacter) {
        long j3;
        long j16;
        String[] split = str.split("\\,");
        if (split.length < 2 || split.length != 2) {
            return null;
        }
        long parseLong = Long.parseLong(split[1]);
        long parseLong2 = Long.parseLong(split[0]);
        if (parseLong < 0) {
            j3 = 0;
        } else {
            j3 = parseLong;
        }
        if (parseLong2 < 0) {
            j16 = 0;
        } else {
            j16 = parseLong2;
        }
        return new LyricCharacter(j16, j3, i3, i16);
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser
    public void init(@NonNull String str) {
        this.mString = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [int] */
    /* JADX WARN: Type inference failed for: r3v24 */
    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Lyric parse() {
        int i3;
        int i16;
        ?? r36;
        BufferedReader bufferedReader;
        String str = this.mString;
        BufferedReader bufferedReader2 = null;
        if (str != null) {
            if (str.contains(QRC_XML_KEY)) {
                i3 = str.indexOf(QRC_XML_KEY);
            } else {
                i3 = -1;
            }
            if (i3 != -1) {
                int i17 = i3 + 12;
                if (str.length() > i17 + 1) {
                    String substring = str.substring(i17);
                    if (!substring.trim().startsWith("=")) {
                        return null;
                    }
                    String substring2 = substring.substring(substring.indexOf("=") + 1);
                    if (!substring2.trim().startsWith(QRC_XML_MARK)) {
                        return null;
                    }
                    String substring3 = substring2.substring(substring2.indexOf(QRC_XML_MARK) + 1);
                    if (substring3.contains(QRC_XML_END)) {
                        i16 = substring3.lastIndexOf(QRC_XML_END);
                    } else {
                        i16 = -1;
                    }
                    if (i16 == -1) {
                        return null;
                    }
                    String substring4 = substring3.substring(0, i16);
                    if (substring4.contains(QRC_XML_MARK)) {
                        r36 = substring4.lastIndexOf(QRC_XML_MARK);
                    } else {
                        r36 = -1;
                    }
                    if (r36 == -1) {
                        return null;
                    }
                    try {
                        try {
                            bufferedReader = new BufferedReader(new StringReader(substring4.substring(0, r36)));
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    parseQrcLine(readLine.trim());
                                } catch (Exception e16) {
                                    e = e16;
                                    Log.e(TAG, e.toString());
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e17) {
                                            Log.e(TAG, e17.toString());
                                        }
                                    }
                                    return null;
                                }
                            }
                            Collections.sort(this.mLineLyricList, mLineComparator);
                            Lyric lyric = new Lyric(2, this.mOffset, this.mLineLyricList);
                            try {
                                bufferedReader.close();
                            } catch (IOException e18) {
                                Log.e(TAG, e18.toString());
                            }
                            return lyric;
                        } catch (Exception e19) {
                            e = e19;
                            bufferedReader = null;
                        } catch (Throwable th5) {
                            th = th5;
                            if (bufferedReader2 != null) {
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        bufferedReader2 = r36;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e26) {
                                Log.e(TAG, e26.toString());
                            }
                        }
                        throw th;
                    }
                }
            }
        }
        return null;
    }
}
