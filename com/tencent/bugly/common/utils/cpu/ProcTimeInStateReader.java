package com.tencent.bugly.common.utils.cpu;

import com.tencent.component.media.MtpConstants;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* loaded from: classes5.dex */
public class ProcTimeInStateReader {
    private static final String TAG = "ProcTimeInStateReader";
    private long[] mFrequenciesKhz;
    private int[] mTimeInStateTimeFormat;
    private static final int[] TIME_IN_STATE_LINE_FREQUENCY_FORMAT = {MtpConstants.RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED, 10};
    private static final int[] TIME_IN_STATE_LINE_TIME_FORMAT = {32, MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED};
    private static final int[] TIME_IN_STATE_HEADER_LINE_FORMAT = {10};

    public ProcTimeInStateReader(Path path) throws IOException {
        initializeTimeInStateFormat(path);
    }

    private void initializeTimeInStateFormat(Path path) throws IOException {
        byte[] readAllBytes;
        readAllBytes = Files.readAllBytes(path);
        IntArray intArray = new IntArray();
        IntArray intArray2 = new IntArray();
        int i3 = 0;
        int i16 = 0;
        while (i3 < readAllBytes.length) {
            if (!Character.isDigit(readAllBytes[i3])) {
                int[] iArr = TIME_IN_STATE_HEADER_LINE_FORMAT;
                intArray.addAll(iArr);
                intArray2.addAll(iArr);
            } else {
                intArray.addAll(TIME_IN_STATE_LINE_FREQUENCY_FORMAT);
                intArray2.addAll(TIME_IN_STATE_LINE_TIME_FORMAT);
                i16++;
            }
            while (i3 < readAllBytes.length && readAllBytes[i3] != 10) {
                i3++;
            }
            i3++;
        }
        if (i16 != 0) {
            long[] jArr = new long[i16];
            if (Process.parseProcLine(readAllBytes, 0, readAllBytes.length, intArray.toArray(), null, jArr, null)) {
                this.mTimeInStateTimeFormat = intArray2.toArray();
                this.mFrequenciesKhz = jArr;
                return;
            }
            throw new IOException("Failed to parse time_in_state file");
        }
        throw new IOException("Empty time_in_state file");
    }

    public long[] getFrequenciesKhz() {
        return this.mFrequenciesKhz;
    }

    public long[] getUsageTimesMillis(Path path) {
        String path2;
        int length = this.mFrequenciesKhz.length;
        long[] jArr = new long[length];
        path2 = path.toString();
        if (!Process.readProcFile(path2, this.mTimeInStateTimeFormat, null, jArr, null)) {
            return null;
        }
        for (int i3 = 0; i3 < length; i3++) {
            jArr[i3] = jArr[i3] * 10;
        }
        return jArr;
    }
}
