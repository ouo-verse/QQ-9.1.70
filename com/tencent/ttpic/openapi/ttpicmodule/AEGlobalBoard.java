package com.tencent.ttpic.openapi.ttpicmodule;

import com.tencent.component.media.image.ProgressTracer;
import java.util.Hashtable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEGlobalBoard {
    private static final String FAIL = "\u5931\u8d25";
    public static boolean PTGlobalBoard_Enable = true;
    private static final String SUCCESS = "\u6210\u529f";
    private static Map<String, String> boardRecords = new Hashtable();

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum PTStatus {
        PTAIDETECTOR_INIT("PTAIDetector\u521d\u59cb\u5316", ""),
        PTAIDETECTOR_CLEAN("PTAIDetector\u6e05\u7406", "");

        private String name;
        private String status;

        PTStatus(String str, String str2) {
            this.name = str;
            this.status = str2;
        }
    }

    public static String getBoard() {
        StringBuffer stringBuffer = new StringBuffer();
        for (PTStatus pTStatus : PTStatus.values()) {
            stringBuffer.append(pTStatus.name + ProgressTracer.SEPARATOR + pTStatus.status + "\n");
        }
        for (Map.Entry<String, String> entry : boardRecords.entrySet()) {
            stringBuffer.append(entry.getKey() + ProgressTracer.SEPARATOR + entry.getValue() + "\n");
        }
        return stringBuffer.toString();
    }

    public static void writeBoard(PTStatus pTStatus, String str) {
        if (PTGlobalBoard_Enable) {
            pTStatus.status = str;
        }
    }

    public static void writeBoard(String str, String str2) {
        if (PTGlobalBoard_Enable) {
            boardRecords.put(str, str2);
        }
    }

    public static void writeBoard(PTStatus pTStatus, int i3) {
        if (PTGlobalBoard_Enable) {
            if (i3 == 0) {
                pTStatus.status = SUCCESS;
            } else {
                pTStatus.status = FAIL;
            }
        }
    }
}
