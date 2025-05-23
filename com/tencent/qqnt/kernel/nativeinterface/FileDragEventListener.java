package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface FileDragEventListener {
    void onDragDetailData(String str);

    void onDragDropped();

    void onDragEntered();

    void onDragExited();

    void onDragFileStart(Position position);

    void onDragFileStop();

    void onDragRawData(ArrayList<String> arrayList);

    void onDragging(Position position);
}
