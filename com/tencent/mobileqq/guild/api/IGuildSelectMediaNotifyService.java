package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes12.dex */
public interface IGuildSelectMediaNotifyService extends IRuntimeService {
    public static final int BUSI_AIO_MEDIA_PREVIEW_LAYER = 2;
    public static final int BUSI_AIO_MEDIA_SELECT_PANEL = 1;

    void addListener(int i3, g gVar);

    void changeSelectMediaRawType(p pVar, int i3);

    int getSelectMediaRawType(p pVar);

    List<String> getSelectedMediaInfoPaths(p pVar);

    ArrayList<LocalMediaInfo> getSelectedMediaInfos(p pVar);

    void onOrderChanged(p pVar);

    void onSelectedChanged(int i3, boolean z16, LocalMediaInfo localMediaInfo, p pVar);

    void removeListener(int i3);

    void removeSelectedMediaInfos(p pVar);

    void resetSelectedMediaInfo(p pVar, ArrayList<LocalMediaInfo> arrayList);
}
