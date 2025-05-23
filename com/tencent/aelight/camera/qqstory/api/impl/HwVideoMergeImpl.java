package com.tencent.aelight.camera.qqstory.api.impl;

import com.tencent.aelight.camera.aioeditor.shortvideo.util.b;
import com.tencent.aelight.camera.qqstory.api.IHwVideoMerge;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class HwVideoMergeImpl implements IHwVideoMerge {
    @Override // com.tencent.aelight.camera.qqstory.api.IHwVideoMerge
    public boolean ffmpegMergeMultiVideo(List<String> list, String str, int i3) {
        return b.g(list, str, i3);
    }
}
