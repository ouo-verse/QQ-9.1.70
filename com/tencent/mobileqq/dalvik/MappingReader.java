package com.tencent.mobileqq.dalvik;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MappingReader {
    static IPatchRedirector $redirector_;
    private List<Mapping> mMappings;

    public MappingReader() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mMappings = new ArrayList();
            getMapsFromFile(new File("/proc/self/maps"));
        }
    }

    private IllegalArgumentException createIAE(String str) {
        return new IllegalArgumentException("Invalid /proc/self/maps line: '" + str + "'");
    }

    private void getMapsFromFile(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList arrayList = new ArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else {
                    arrayList.add(readLine);
                }
            }
            if (arrayList.size() > 0) {
                getMapsFromMapLines(arrayList);
            }
        } finally {
            fileReader.close();
        }
    }

    private void getMapsFromMapLines(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.mMappings.add(getRwMap(it.next()));
        }
    }

    private final long[] getMergedIntervals(List<Mapping> list) {
        ArrayList arrayList = new ArrayList();
        long j3 = -1;
        long j16 = -1;
        for (Mapping mapping : list) {
            if (j3 == -1) {
                j3 = mapping.beginAddr;
                j16 = mapping.endAddr;
            } else if (mapping.beginAddr == j16) {
                j16 = mapping.endAddr;
            } else {
                arrayList.add(Long.valueOf(j3));
                arrayList.add(Long.valueOf(j16));
                j3 = mapping.beginAddr;
                j16 = mapping.endAddr;
            }
        }
        if (j3 != -1) {
            arrayList.add(Long.valueOf(j3));
            arrayList.add(Long.valueOf(j16));
        }
        long[] jArr = new long[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            jArr[i3] = ((Long) arrayList.get(i3)).longValue();
        }
        return jArr;
    }

    private Mapping getRwMap(String str) {
        String[] split = str.split(" +", 6);
        if (split.length == 6) {
            String[] split2 = split[0].split("-");
            if (split2.length == 2) {
                try {
                    long parseLong = Long.parseLong(split2[0], 16);
                    long parseLong2 = Long.parseLong(split2[1], 16);
                    if (split[1].length() == 4) {
                        boolean isEquals = isEquals(split[1].charAt(0), 'r', str);
                        boolean isEquals2 = isEquals(split[1].charAt(1), 'w', str);
                        split[1].charAt(3);
                        return new Mapping(parseLong, parseLong2, isEquals, isEquals2, true, split[5]);
                    }
                    throw createIAE(str);
                } catch (NumberFormatException unused) {
                    throw createIAE(str);
                }
            }
            throw createIAE(str);
        }
        throw createIAE(str);
    }

    private boolean isEquals(char c16, char c17, String str) {
        if (c16 == c17) {
            return true;
        }
        if (c16 == '-') {
            return false;
        }
        throw createIAE(str);
    }

    public final Mapping findMappingByName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Mapping) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        for (Mapping mapping : this.mMappings) {
            if (mapping.pathName.contains(str)) {
                return mapping;
            }
        }
        return null;
    }

    public final long[] getReadableMaps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (long[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        for (Mapping mapping : this.mMappings) {
            if (mapping.readable) {
                arrayList.add(mapping);
            }
        }
        return getMergedIntervals(arrayList);
    }
}
