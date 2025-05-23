package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mm.vfs.FileSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: P */
/* loaded from: classes9.dex */
public class CombinedFileSystem extends DelegateFileSystem {
    public static final Parcelable.Creator<CombinedFileSystem> CREATOR = new Parcelable.Creator<CombinedFileSystem>() { // from class: com.tencent.mm.vfs.CombinedFileSystem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombinedFileSystem createFromParcel(Parcel parcel) {
            return new CombinedFileSystem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CombinedFileSystem[] newArray(int i3) {
            return new CombinedFileSystem[i3];
        }
    };
    private static final String GLOB_META_CHARS = "\\*?[{";
    private static final String REGEX_META_CHARS = ".^$+{[]|()";
    private static final int VERSION = 1;
    private final int mCaps;
    private final FileSystem[] mFSList;
    private final PatternEntry[] mPatternList;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static final class PatternEntry {

        /* renamed from: fs, reason: collision with root package name */
        final FileSystem f154040fs;
        final int fsIdx;
        final Pattern pattern;

        PatternEntry(Pattern pattern, int i3, FileSystem fileSystem) {
            this.pattern = pattern;
            this.fsIdx = i3;
            this.f154040fs = fileSystem;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0105, code lost:
    
        r6 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011d A[EDGE_INSN: B:106:0x011d->B:91:0x011d BREAK  A[LOOP:1: B:59:0x00b6->B:76:0x00b6], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0126 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pattern globToRegexPattern(String str) {
        int i3;
        boolean z16;
        if (str == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(AECameraConstants.WIDGETINFO_SEPARATE);
        if (str.startsWith("**/")) {
            sb5.append("(?:.*/)?");
            i3 = 3;
            z16 = false;
        } else {
            i3 = 0;
            z16 = false;
        }
        while (i3 < str.length()) {
            int i16 = i3 + 1;
            char charAt = str.charAt(i3);
            if (charAt != '*') {
                if (charAt != ',') {
                    if (charAt != '?') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                if (charAt != '[') {
                                    if (charAt != '\\') {
                                        if (isRegexMeta(charAt)) {
                                            sb5.append('\\');
                                        }
                                        sb5.append(charAt);
                                    } else if (i16 != str.length()) {
                                        i3 = i16 + 1;
                                        char charAt2 = str.charAt(i16);
                                        if (isGlobMeta(charAt2) || isRegexMeta(charAt2)) {
                                            sb5.append('\\');
                                        }
                                        sb5.append(charAt2);
                                    } else {
                                        throw new PatternSyntaxException("No character to escape", str, i16 - 1);
                                    }
                                } else {
                                    sb5.append("[[^/]&&[");
                                    if (nextChar(str, i16) == '^') {
                                        sb5.append("\\^");
                                    } else {
                                        if (nextChar(str, i16) == '!') {
                                            sb5.append('^');
                                            i16++;
                                        }
                                        if (nextChar(str, i16) == '-') {
                                            sb5.append('-');
                                        }
                                        boolean z17 = false;
                                        char c16 = 0;
                                        while (true) {
                                            if (i16 < str.length()) {
                                                break;
                                            }
                                            int i17 = i16 + 1;
                                            char charAt3 = str.charAt(i16);
                                            if (charAt3 == ']') {
                                                i16 = i17;
                                                charAt = charAt3;
                                                break;
                                            }
                                            if (charAt3 != '/') {
                                                if (charAt3 == '\\' || charAt3 == '[' || (charAt3 == '&' && nextChar(str, i17) == '&')) {
                                                    sb5.append('\\');
                                                }
                                                sb5.append(charAt3);
                                                if (charAt3 == '-') {
                                                    if (z17) {
                                                        int i18 = i17 + 1;
                                                        charAt = nextChar(str, i17);
                                                        if (charAt == 0 || charAt == ']') {
                                                            break;
                                                        }
                                                        if (charAt >= c16) {
                                                            sb5.append(charAt);
                                                            i16 = i18;
                                                            z17 = false;
                                                        } else {
                                                            throw new PatternSyntaxException("Invalid range", str, i18 - 3);
                                                        }
                                                    } else {
                                                        throw new PatternSyntaxException("Invalid range", str, i17 - 1);
                                                    }
                                                } else {
                                                    c16 = charAt3;
                                                    z17 = true;
                                                    i16 = i17;
                                                    charAt = c16;
                                                }
                                            } else {
                                                throw new PatternSyntaxException("Explicit 'name separator' in class", str, i17 - 1);
                                            }
                                        }
                                        if (charAt != ']') {
                                            sb5.append("]]");
                                        } else {
                                            throw new PatternSyntaxException("Missing ']", str, i16 - 1);
                                        }
                                    }
                                    i16++;
                                    boolean z172 = false;
                                    char c162 = 0;
                                    while (true) {
                                        if (i16 < str.length()) {
                                        }
                                    }
                                    if (charAt != ']') {
                                    }
                                }
                            } else if (z16) {
                                sb5.append("))");
                                z16 = false;
                            } else {
                                sb5.append('}');
                            }
                        } else if (!z16) {
                            sb5.append("(?:(?:");
                            i3 = i16;
                            z16 = true;
                        } else {
                            throw new PatternSyntaxException("Cannot nest groups", str, i16 - 1);
                        }
                    } else {
                        sb5.append("[^/]");
                    }
                } else if (z16) {
                    sb5.append(")|(?:");
                } else {
                    sb5.append(',');
                }
            } else if (nextChar(str, i16) == '*') {
                sb5.append(".*");
                i16++;
            } else {
                sb5.append("[^/]*");
            }
            i3 = i16;
        }
        if (!z16) {
            sb5.append('$');
            return Pattern.compile(sb5.toString());
        }
        throw new PatternSyntaxException("Missing '}", str, i3 - 1);
    }

    private static boolean isGlobMeta(char c16) {
        if (GLOB_META_CHARS.indexOf(c16) != -1) {
            return true;
        }
        return false;
    }

    private static boolean isRegexMeta(char c16) {
        if (REGEX_META_CHARS.indexOf(c16) != -1) {
            return true;
        }
        return false;
    }

    private static char nextChar(String str, int i3) {
        if (i3 < str.length()) {
            return str.charAt(i3);
        }
        return (char) 0;
    }

    private static List<String> zeroSplit(String str) {
        ArrayList arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, "\u0000");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem
    protected Iterable<FileSystem> allFileSystems() {
        return Arrays.asList(this.mFSList);
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public int capabilityFlags() {
        return this.mCaps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mm.vfs.DelegateFileSystem
    public FileSystem delegate(String str, int i3) {
        for (PatternEntry patternEntry : this.mPatternList) {
            Pattern pattern = patternEntry.pattern;
            if (pattern == null || pattern.matcher(str).matches()) {
                return patternEntry.f154040fs;
            }
        }
        return null;
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public FileSystem.FsStat fileSystemStat(String str) {
        return this.mFSList[r0.length - 1].fileSystemStat(str);
    }

    @Override // com.tencent.mm.vfs.DelegateFileSystem, com.tencent.mm.vfs.FileSystem
    public boolean mkdirs(String str) {
        boolean z16 = false;
        for (FileSystem fileSystem : this.mFSList) {
            z16 |= fileSystem.mkdirs(str);
        }
        return z16;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("CombinedFS [");
        for (FileSystem fileSystem : this.mFSList) {
            sb5.append(fileSystem.toString());
            sb5.append(", ");
        }
        sb5.setLength(sb5.length() - 2);
        sb5.append(']');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String pattern;
        VFSUtils.writeFileSystemVersion(parcel, CombinedFileSystem.class, 1);
        parcel.writeInt(this.mFSList.length);
        for (FileSystem fileSystem : this.mFSList) {
            parcel.writeParcelable(fileSystem, i3);
        }
        parcel.writeInt(this.mPatternList.length);
        for (PatternEntry patternEntry : this.mPatternList) {
            Pattern pattern2 = patternEntry.pattern;
            if (pattern2 == null) {
                pattern = null;
            } else {
                pattern = pattern2.pattern();
            }
            parcel.writeString(pattern);
            parcel.writeInt(patternEntry.fsIdx);
        }
    }

    public CombinedFileSystem(FileSystem[] fileSystemArr, String[] strArr) {
        if (fileSystemArr != null && strArr != null && fileSystemArr.length != 0 && strArr.length != 0) {
            if (fileSystemArr.length == strArr.length) {
                this.mFSList = new FileSystem[fileSystemArr.length];
                int i3 = 0;
                for (int i16 = 0; i16 < fileSystemArr.length; i16++) {
                    FileSystem fileSystem = fileSystemArr[i16];
                    if (fileSystem != null) {
                        this.mFSList[i16] = fileSystem;
                        i3 |= fileSystemArr[i16].capabilityFlags();
                    } else {
                        throw new IllegalArgumentException("Wrong wrapped filesystem.");
                    }
                }
                this.mCaps = i3;
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < strArr.length; i17++) {
                    String str = strArr[i17];
                    if (str == null) {
                        arrayList.add(new PatternEntry(null, i17, this.mFSList[i17]));
                    } else {
                        Iterator<String> it = zeroSplit(str).iterator();
                        while (it.hasNext()) {
                            arrayList.add(new PatternEntry(globToRegexPattern(it.next()), i17, this.mFSList[i17]));
                        }
                    }
                }
                PatternEntry[] patternEntryArr = new PatternEntry[arrayList.size()];
                this.mPatternList = patternEntryArr;
                arrayList.toArray(patternEntryArr);
                return;
            }
            throw new IllegalArgumentException("fs and globPattern must have the same length");
        }
        throw new IllegalArgumentException("fs and/or globPatterns is null");
    }

    CombinedFileSystem(Parcel parcel) {
        VFSUtils.checkFileSystemVersion(parcel, CombinedFileSystem.class, 1);
        int readInt = parcel.readInt();
        this.mFSList = new FileSystem[readInt];
        int i3 = 0;
        for (int i16 = 0; i16 < readInt; i16++) {
            FileSystem fileSystem = (FileSystem) parcel.readParcelable(getClass().getClassLoader());
            if (fileSystem != null) {
                this.mFSList[i16] = fileSystem;
                i3 |= fileSystem.capabilityFlags();
            } else {
                throw new ParcelFormatException();
            }
        }
        this.mCaps = i3;
        int readInt2 = parcel.readInt();
        this.mPatternList = new PatternEntry[readInt2];
        for (int i17 = 0; i17 < readInt2; i17++) {
            String readString = parcel.readString();
            Pattern compile = readString == null ? null : Pattern.compile(readString);
            int readInt3 = parcel.readInt();
            this.mPatternList[i17] = new PatternEntry(compile, readInt3, this.mFSList[readInt3]);
        }
    }
}
