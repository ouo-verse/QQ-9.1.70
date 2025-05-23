package com.tencent.mobileqq.dov.story.api;

import NS_COMM.COMM;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IVSReporter extends QRouteApi {
    public static final String REPORT_SMART_MUSIC_DOWNLOAD = "edit_music_download";

    List<COMM.Entry> newPerfEntries(int i3, long j3, String str, long j16);

    void reportPerfEvent(String str, List<COMM.Entry> list);
}
