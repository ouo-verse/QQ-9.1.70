package com.huawei.hms.common.data;

import android.os.Bundle;
import com.qzone.misc.network.uploader.report.BusinessReport;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    DataBufferUtils() {
    }

    private static boolean a(Bundle bundle, String str) {
        if (bundle == null || bundle.getString(str) == null) {
            return false;
        }
        return true;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        BusinessReport.AnonymousClass1 anonymousClass1 = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        Iterator<E> it = dataBuffer.iterator();
        while (it.hasNext()) {
            anonymousClass1.add((BusinessReport.AnonymousClass1) it.next().freeze());
        }
        dataBuffer.release();
        return anonymousClass1;
    }

    public static boolean hasData(DataBuffer<?> dataBuffer) {
        if (dataBuffer == null || dataBuffer.getCount() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean hasNextPage(DataBuffer<?> dataBuffer) {
        return a(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(DataBuffer<?> dataBuffer) {
        return a(dataBuffer.getMetadata(), PREV_PAGE);
    }
}
