package com.tencent.mobileqq.emoticon.data;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface EmoticonTabInfo {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface TabType {
        public static final int BIG_EMOTICON = 6;
        public static final int FAVORITE = 5;
        public static final int HOT_PIC = 12;
        public static final int SYSTEM = 1;
        public static final int SYSTEM_AND_EMOJI = 7;
    }

    EmoticonDataSource getDataSource();

    List<EmoticonInfo> getEmoticons();

    Drawable getTabIcon();

    String getTabName();

    int getTabType();
}
