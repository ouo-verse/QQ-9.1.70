package com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.data.Lyric;
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
public class LrcParserWEmptyLine implements IParser {
    private static final String OFFSET_TAG = "offset";
    public static final String TAG = "LrcParserWEmptyLine";
    private ArrayList<Sentence> mLineLyricList = new ArrayList<>();
    private int mOffset;
    private String mString;
    private static final Pattern mPattern = Pattern.compile("(?<=\\[).*?(?=\\])");
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

    private void parseLine(String str) {
        String trim;
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
                        long parseTime = parseTime((String) it.next());
                        if (parseTime != -1) {
                            Sentence sentence = new Sentence();
                            sentence.mText = substring;
                            sentence.mStartTime = parseTime;
                            this.mLineLyricList.add(sentence);
                        }
                    }
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
                try {
                    if (i17 > str.length()) {
                        i17 = str.length();
                    }
                    trim = str.substring(i17).trim();
                    if (trim.length() == 0) {
                        trim = " ";
                    }
                } catch (Exception e16) {
                    Log.e(TAG, e16.toString());
                }
                if (trim.length() == 0 && this.mOffset == 0) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        int parseOffset = parseOffset((String) it5.next());
                        if (parseOffset != Integer.MAX_VALUE) {
                            this.mOffset = parseOffset;
                            break;
                        }
                    }
                    return;
                }
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    long parseTime2 = parseTime((String) it6.next());
                    if (parseTime2 != -1 && trim.length() > 0) {
                        Sentence sentence2 = new Sentence();
                        sentence2.mText = trim;
                        sentence2.mStartTime = parseTime2;
                        this.mLineLyricList.add(sentence2);
                    }
                }
            } finally {
                arrayList.clear();
            }
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

    private long parseTime(String str) {
        String[] split = str.split("\\:|\\.");
        if (split.length < 2) {
            return -1L;
        }
        if (split.length == 2) {
            try {
                if (this.mOffset == 0 && split[0].equalsIgnoreCase("offset")) {
                    this.mOffset = Integer.parseInt(split[1]);
                    return -1L;
                }
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt >= 0 && parseInt2 >= 0 && parseInt2 < 60) {
                    return ((parseInt * 60) + parseInt2) * 1000;
                }
                throw new RuntimeException("\u6570\u5b57\u4e0d\u5408\u6cd5!");
            } catch (Exception unused) {
                return -1L;
            }
        }
        if (split.length == 3) {
            try {
                int parseInt3 = Integer.parseInt(split[0]);
                int parseInt4 = Integer.parseInt(split[1]);
                int parseInt5 = Integer.parseInt(split[2]);
                if (parseInt3 >= 0 && parseInt4 >= 0 && parseInt4 < 60 && parseInt5 >= 0 && parseInt5 <= 999) {
                    return (((parseInt3 * 60) + parseInt4) * 1000) + (parseInt5 * 10);
                }
                throw new RuntimeException("\u6570\u5b57\u4e0d\u5408\u6cd5!");
            } catch (Exception unused2) {
            }
        }
        return -1L;
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser
    public void init(@NonNull String str) {
        this.mString = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.qcircle.weseevideo.editor.sticker.music.lyric.parse.parser.IParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Lyric parse() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new StringReader(this.mString));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        parseLine(readLine.trim());
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e16) {
                                Log.e(TAG, e16.toString());
                            }
                        }
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                    Log.e(TAG, e.toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e18) {
                            Log.e(TAG, e18.toString());
                        }
                    }
                    return null;
                }
            }
            Collections.sort(this.mLineLyricList, mLineComparator);
            for (int i3 = 0; i3 < this.mLineLyricList.size(); i3++) {
                if (i3 < this.mLineLyricList.size() - 1) {
                    this.mLineLyricList.get(i3).mDuration = this.mLineLyricList.get(i3 + 1).mStartTime - this.mLineLyricList.get(i3).mStartTime;
                } else {
                    this.mLineLyricList.get(i3).mDuration = 999999L;
                }
            }
            Lyric lyric = new Lyric(1, this.mOffset, this.mLineLyricList);
            try {
                bufferedReader.close();
            } catch (IOException e19) {
                Log.e(TAG, e19.toString());
            }
            return lyric;
        } catch (Exception e26) {
            e = e26;
            bufferedReader = null;
        } catch (Throwable th6) {
            th = th6;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
    }
}
