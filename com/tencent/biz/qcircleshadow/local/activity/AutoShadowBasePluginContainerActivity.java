package com.tencent.biz.qcircleshadow.local.activity;

import android.content.res.Configuration;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.IPermissionRequester;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;

/* loaded from: classes4.dex */
public class AutoShadowBasePluginContainerActivity extends PluginContainerActivity implements IPermissionRequester {

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray<List> f82542d = new SparseArray<>();

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity, android.app.Activity, android.view.Window.Callback, com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity
    public String getUUID(String str) {
        return ASEngineConstants.BusinessKeyToUUID.sUUID.get(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.qcircle.container.PluginContainerActivity, android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i3, strArr, iArr);
        if (iArr.length == 0) {
            return;
        }
        List list = this.f82542d.get(i3);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof QQPermissionCallback) {
                        QQPermissionCallback qQPermissionCallback = (QQPermissionCallback) obj;
                        ArrayList arrayList = new ArrayList();
                        for (int i16 = 0; i16 < iArr.length; i16++) {
                            if (iArr[i16] != 0) {
                                arrayList.add(strArr[i16]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            qQPermissionCallback.deny(i3, strArr, iArr);
                        } else {
                            qQPermissionCallback.grant(i3, strArr, iArr);
                        }
                    } else {
                        QQPermissionHelper.requestResult(obj, i3, strArr, iArr);
                    }
                }
            }
        }
        if (list != null) {
            this.f82542d.remove(i3);
        }
    }

    @Override // mqq.app.IPermissionRequester
    public void requestPermissions(Object obj, int i3, String... strArr) {
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        for (String str : strArr) {
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            List list = this.f82542d.get(i3);
            if (list == null) {
                list = new ArrayList();
            }
            int size = list.size();
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                Object obj2 = list.get(i16);
                if (obj2 != null && obj2 == obj) {
                    z16 = true;
                    break;
                }
                i16++;
            }
            if (!z16) {
                list.add(obj);
                this.f82542d.put(i3, list);
            }
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), i3);
            return;
        }
        if (obj instanceof QQPermissionCallback) {
            ((QQPermissionCallback) obj).grant(i3, strArr, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(obj, i3);
        }
    }
}
