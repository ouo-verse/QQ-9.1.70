package com.qzone.reborn.part.publish.common.mediapick;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes37.dex */
public class QZoneMediaPickInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public final ArrayList<String> selectMediaPathList = new ArrayList<>();
    public final HashMap<String, LocalMediaInfo> selectedMediaInfoMap = new HashMap<>();
    public final ArrayList<String> editImageList = new ArrayList<>();
}
