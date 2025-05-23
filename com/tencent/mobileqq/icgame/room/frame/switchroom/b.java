package com.tencent.mobileqq.icgame.room.frame.switchroom;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.ISwitchRoomList;
import com.tencent.mobileqq.icgame.api.room.impl.SwitchRoomListImpl;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchDirection;
import com.tencent.mobileqq.icgame.base.room.multipage.api.SwitchPageInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lz0.d;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static d f237605c;

    /* renamed from: d, reason: collision with root package name */
    private static List<SwitchPageInfo> f237606d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, ISwitchRoomList> f237607a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final IAegisLogApi f237608b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public b() {
        this.f237607a.put("1", new SwitchRoomListImpl());
    }

    public void a() {
        QLog.i("ICGameRoomSwitchDataModel", 1, HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        d dVar = f237605c;
        if (dVar != null) {
            dVar.a();
            f237605c = null;
        }
        List<SwitchPageInfo> list = f237606d;
        if (list != null) {
            list.clear();
        }
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl != null && sDKImpl.isInited()) {
            sDKImpl.clearFetchRoomList();
        }
    }

    public void b(List<SwitchPageInfo> list, SwitchDirection switchDirection, int i3, a aVar) {
        QLog.i("ICGameRoomSwitchDataModel", 1, "queryRoomList, size " + list.size() + ", index " + i3);
        if (list.size() - i3 > 3) {
            if (aVar != null) {
                aVar.a(-1, i3, new ArrayList(list));
            }
        } else if (list.isEmpty()) {
            if (aVar != null) {
                aVar.a(-1, i3, Collections.emptyList());
            }
        } else if (aVar != null) {
            aVar.a(-1, i3, new ArrayList(list));
        }
    }
}
