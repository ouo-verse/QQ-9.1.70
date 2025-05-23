package com.tencent.mobileqq.triton.font;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TTFFile {
    private Map<TTFTableName, TTFDirTabEntry> dirTabs;
    private FontFileReader fontFile;
    private final Set<String> familyNames = new HashSet();
    private String postScriptName = "";
    private String fullName = "";
    private String notice = "";
    private String subFamilyName = "";

    private void readDirTabs() throws IOException {
        this.fontFile.readTTFLong();
        int readTTFUShort = this.fontFile.readTTFUShort();
        this.fontFile.skip(6L);
        this.dirTabs = new HashMap();
        TTFDirTabEntry[] tTFDirTabEntryArr = new TTFDirTabEntry[readTTFUShort];
        for (int i3 = 0; i3 < readTTFUShort; i3++) {
            TTFDirTabEntry tTFDirTabEntry = new TTFDirTabEntry();
            tTFDirTabEntryArr[i3] = tTFDirTabEntry;
            this.dirTabs.put(TTFTableName.getValue(tTFDirTabEntry.read(this.fontFile)), tTFDirTabEntryArr[i3]);
        }
        this.dirTabs.put(TTFTableName.TABLE_DIRECTORY, new TTFDirTabEntry(0L, this.fontFile.getCurrentPos()));
    }

    private void readName() throws IOException {
        String readTTFString;
        seekTab(this.fontFile, TTFTableName.NAME, 2L);
        int currentPos = this.fontFile.getCurrentPos();
        int readTTFUShort = this.fontFile.readTTFUShort();
        int readTTFUShort2 = (this.fontFile.readTTFUShort() + currentPos) - 2;
        int i3 = currentPos + 4;
        while (true) {
            int i16 = readTTFUShort - 1;
            if (readTTFUShort > 0) {
                this.fontFile.seekSet(i3);
                int readTTFUShort3 = this.fontFile.readTTFUShort();
                int readTTFUShort4 = this.fontFile.readTTFUShort();
                int readTTFUShort5 = this.fontFile.readTTFUShort();
                int readTTFUShort6 = this.fontFile.readTTFUShort();
                int readTTFUShort7 = this.fontFile.readTTFUShort();
                if ((readTTFUShort3 == 1 || readTTFUShort3 == 3) && (readTTFUShort4 == 0 || readTTFUShort4 == 1)) {
                    this.fontFile.seekSet(r9.readTTFUShort() + readTTFUShort2);
                    if (readTTFUShort3 == 3) {
                        readTTFString = this.fontFile.readTTFString(readTTFUShort7, readTTFUShort4);
                    } else {
                        readTTFString = this.fontFile.readTTFString(readTTFUShort7);
                    }
                    readNameState(readTTFUShort6, readTTFString, readTTFUShort3, readTTFUShort5);
                }
                i3 += 12;
                readTTFUShort = i16;
            } else {
                return;
            }
        }
    }

    private void readNameState(int i3, String str, int i16, int i17) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 != 6) {
                            if (i3 != 16) {
                                return;
                            }
                        } else {
                            if (this.postScriptName.length() == 0) {
                                this.postScriptName = str;
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.fullName.length() == 0 || (i16 == 3 && i17 == 1033)) {
                            this.fullName = str;
                            return;
                        }
                        return;
                    }
                } else {
                    if (this.subFamilyName.length() == 0) {
                        this.subFamilyName = str;
                        return;
                    }
                    return;
                }
            }
            this.familyNames.add(str);
            return;
        }
        if (this.notice.length() == 0) {
            this.notice = str;
        }
    }

    private boolean seekTab(FontFileReader fontFileReader, TTFTableName tTFTableName, long j3) throws IOException {
        TTFDirTabEntry tTFDirTabEntry = this.dirTabs.get(tTFTableName);
        if (tTFDirTabEntry == null) {
            return false;
        }
        fontFileReader.seekSet(tTFDirTabEntry.getOffset() + j3);
        return true;
    }

    public Set<String> getFamilyNames() {
        return this.familyNames;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getNotice() {
        return this.notice;
    }

    public String getPostScriptName() {
        return this.postScriptName;
    }

    public String getSubFamilyName() {
        return this.subFamilyName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFont(FontFileReader fontFileReader) throws IOException {
        this.fontFile = fontFileReader;
        readDirTabs();
        readName();
    }
}
