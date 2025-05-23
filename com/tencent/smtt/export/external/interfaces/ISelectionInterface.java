package com.tencent.smtt.export.external.interfaces;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ISelectionInterface {
    public static final int CARETSELECTION = 1;
    public static final int EDITABLESELECTION = 4;
    public static final short HELD_FIRST_WIDGET = 0;
    public static final short HELD_NOTHING = -1;
    public static final short HELD_SECOND_WIDGET = 1;
    public static final int INPUTSELECTION = 2;
    public static final int NONESELECTION = 0;
    public static final int NORMALSELECTION = 3;

    @Deprecated
    String getText();

    void hideSelectionView();

    void onRetrieveFingerSearchContextResponse(String str, String str2, int i3);

    @Deprecated
    void onSelectCancel();

    @Deprecated
    void onSelectionBegin(Rect rect, Rect rect2, int i3, int i16, short s16);

    @Deprecated
    void onSelectionBeginFailed(int i3, int i16);

    @Deprecated
    void onSelectionChange(Rect rect, Rect rect2, int i3, int i16, short s16);

    void onSelectionDone(Rect rect, boolean z16);

    @Deprecated
    void setText(String str, boolean z16);

    void updateHelperWidget(Rect rect, Rect rect2);
}
