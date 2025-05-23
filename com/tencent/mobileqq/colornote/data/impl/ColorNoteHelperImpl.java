package com.tencent.mobileqq.colornote.data.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.settings.c;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ea1.d;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteHelperImpl implements IColorNoteHelper {
    private static final String TAG = "ColorNoteHelper";
    private static List<d> dataCallbacks = new ArrayList();

    static {
        try {
            Iterator<Class<? extends d>> it = ea1.a.f396024a.iterator();
            while (it.hasNext()) {
                dataCallbacks.add(it.next().newInstance());
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[static] ", e16);
        }
    }

    private void addColorNoteInner(ColorNote colorNote) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (colorNote.mExtra == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        AppRuntime appRuntime = getAppRuntime();
        IColorNoteDataService dataService = getDataService();
        if (dataService != null && appRuntime != null) {
            colorNote.animate = true;
            if (isProxyValidAndCanAddNote(colorNote, z16, dataService)) {
                dataService.addColorNote(appRuntime.getCurrentUin(), colorNote, null, false);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "addColorNoteInner~~~ " + colorNote);
                }
                if (colorNote.mExtra != 2) {
                    SharedPreferences b16 = ColorNoteSmallScreenUtil.b(BaseApplication.getContext(), appRuntime.getCurrentUin());
                    boolean z19 = b16.getBoolean("color_note_permission_music", true);
                    int i3 = colorNote.mServiceType;
                    if (i3 != 16973824 && i3 != 17367040) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (z17 && !z19) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (z18) {
                        ColorNoteSmallScreenUtil.q(appRuntime, true, false, colorNote);
                        if (z17) {
                            b16.edit().putBoolean("color_note_permission_music", false).apply();
                        }
                    }
                    if (z17) {
                        ColorNoteSmallScreenUtil.v(BaseApplication.getContext());
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addColorNoteInner~~~ fail cause count limit, maxCount = " + com.tencent.mobileqq.colornote.a.f201327a + " , currCount = " + dataService.getCurrentColorNoteCount());
                return;
            }
            return;
        }
        QLog.d(TAG, 1, "[addColorNoteInner] ColorNote: ", colorNote.toString());
    }

    private EIPCResult doIpcCall(String str, String str2, Bundle bundle) {
        Object valueOf;
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), str, str2, bundle);
        if ((callServer == null || callServer.isSuccess()) && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addColorNote eipcResult = ");
            if (callServer == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(callServer.isSuccess());
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
        return callServer;
    }

    private AppRuntime getAppRuntime() {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            return mobileQQ.peekAppRuntime();
        }
        return null;
    }

    private IColorNoteDataService getDataService() {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime == null) {
            QLog.e(TAG, 1, "[getDataService] appRuntime is null.");
            return null;
        }
        return (IColorNoteDataService) appRuntime.getRuntimeService(IColorNoteDataService.class, "all");
    }

    private boolean inColorNoteCollection(String str, List<ColorNote> list) {
        Iterator<ColorNote> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getUniKey().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean inMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    private static boolean isProxyValidAndCanAddNote(ColorNote colorNote, boolean z16, IColorNoteDataService iColorNoteDataService) {
        if (iColorNoteDataService != null && (iColorNoteDataService.canAddColorNote() || z16 || colorNote.getServiceType() == 16973824 || colorNote.getServiceType() == 17367040)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clearHistoryNote$0(int i3) {
        Object valueOf;
        Bundle bundle = new Bundle();
        bundle.putInt("color_note_service_type", i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_clear_history_color_notes", bundle);
        if ((callServer == null || callServer.isSuccess()) && QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("clearHistoryNote eipcResult = ");
            if (callServer == null) {
                valueOf = "null";
            } else {
                valueOf = Boolean.valueOf(callServer.isSuccess());
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    private boolean updateRecentNoteInner(ColorNote colorNote) {
        AppRuntime appRuntime = getAppRuntime();
        IColorNoteDataService dataService = getDataService();
        if (colorNote != null) {
            QLog.d(TAG, 1, "[updateRecentNoteInner] data: ", colorNote.toString());
        }
        if (dataService != null && appRuntime != null) {
            ColorNoteSmallScreenUtil.p(appRuntime, true, false);
            return dataService.updateRecentNote(appRuntime.getCurrentUin(), colorNote);
        }
        QLog.d(TAG, 1, "[updateRecentNoteInner] runtimeService null.");
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean addColorNote(Bundle bundle) {
        Object valueOf;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "addColorNote~~~");
        }
        if (MobileQQ.sProcessId == 1) {
            ColorNote colorNote = new ColorNote(bundle);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addColorNote~~~ main " + colorNote.toString());
            }
            addColorNoteInner(colorNote);
            return true;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_add_colornote", bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("extra_add_colornote_succ", false);
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addColorNote eipcResult = ");
        if (callServer == null) {
            valueOf = "null";
        } else {
            valueOf = Boolean.valueOf(callServer.isSuccess());
        }
        sb5.append(valueOf);
        QLog.d(TAG, 2, sb5.toString());
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean canAddColorNote() {
        Object valueOf;
        if (MobileQQ.sProcessId == 1) {
            IColorNoteDataService dataService = getDataService();
            if (dataService != null) {
                return dataService.canAddColorNote();
            }
            QLog.d(TAG, 1, "[canAddColorNote] in main process, cannot get runtimeService");
            return false;
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_can_add_colornote", null);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("extra_can_add_colornote", true);
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("deleteColorNote eipcResult = ");
        if (callServer == null) {
            valueOf = "null";
        } else {
            valueOf = Boolean.valueOf(callServer.isSuccess());
        }
        sb5.append(valueOf);
        QLog.d(TAG, 2, sb5.toString());
        return false;
    }

    protected boolean canAddColorNoteInner() {
        boolean z16 = false;
        if (MobileQQ.sProcessId == 1) {
            IColorNoteDataService dataService = getDataService();
            if (dataService != null && dataService.canAddColorNote()) {
                z16 = true;
            }
            QLog.d(TAG, 2, "[canAddColorNoteInner] canAddColorNote: " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public void clearHistoryNote(final int i3) {
        if (MobileQQ.sProcessId == 1) {
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime != null) {
                c.c(appRuntime, i3);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.data.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ColorNoteHelperImpl.lambda$clearHistoryNote$0(i3);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public void deleteAllColorNote(AppRuntime appRuntime, ProxyListener proxyListener) {
        IColorNoteDataService dataService = getDataService();
        if (dataService == null) {
            QLog.d(TAG, 2, "[deleteAllColorNote] runtimeService null");
            return;
        }
        ArrayList<ColorNote> deleteAllColorNote = dataService.deleteAllColorNote(appRuntime.getCurrentAccountUin(), proxyListener);
        Iterator<d> it = dataCallbacks.iterator();
        while (it.hasNext()) {
            it.next().a(deleteAllColorNote);
        }
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean deleteColorNote(int i3, String str) {
        return deleteColorNote(i3, str, 0);
    }

    protected void deleteColorNoteInner(String str, int i3) {
        ColorNote colorNote;
        IColorNoteDataService dataService = getDataService();
        if (dataService != null) {
            colorNote = dataService.findColorNoteByKey(str, i3);
        } else {
            QLog.d(TAG, 1, "[deleteColorNoteInner] runtimeService null, key: ", str);
            colorNote = null;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (colorNote != null && appRuntime != null) {
            dataService.deleteColorNote(appRuntime.getCurrentUin(), colorNote, null);
            ColorNoteSmallScreenUtil.m(appRuntime.getApp(), 3, false);
            String[] strArr = {colorNote.getServiceType() + ""};
            String[] strArr2 = {colorNote.getSubType()};
            Intent intent = new Intent("key_delete_item_call");
            intent.putExtra("key_color_note_servicetype_list", strArr);
            intent.putExtra("key_color_note_suptype_list", strArr2);
            intent.putExtra("extra_can_add_colornote", dataService.canAddColorNote());
            intent.putExtras(colorNote.parseBundle());
            BaseApplication.getContext().sendBroadcast(intent);
            Iterator<d> it = dataCallbacks.iterator();
            while (it.hasNext()) {
                it.next().b(colorNote);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean isColorNoteExit(int i3, String str) {
        return isColorNoteExit(i3, str, 0);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.d(TAG, 1, "[onCreate]");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.d(TAG, 1, "[onDestroy]");
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean updateColorNote(String str, String str2, Object obj) {
        return updateColorNote(str, str2, obj, 0);
    }

    protected boolean updateColorNoteInner(String str, String str2, Object obj) {
        ColorNote colorNote;
        boolean z16 = false;
        if (MobileQQ.sProcessId == 1) {
            AppRuntime appRuntime = getAppRuntime();
            IColorNoteDataService dataService = getDataService();
            if (dataService != null && appRuntime != null) {
                colorNote = dataService.updateColorNoteFieldByKey(appRuntime.getCurrentUin(), str, str2, obj);
            } else {
                colorNote = null;
            }
            if (colorNote != null) {
                z16 = true;
            }
        }
        QLog.d(TAG, 2, "updateColorNoteInner~~~ unikey " + str + ", result" + z16);
        return z16;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public Bundle updateColorNoteState(int i3, String str, boolean z16) {
        return updateColorNoteState(i3, str, z16, 0);
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean updateRecentNote(ColorNote colorNote) {
        String str;
        if (MobileQQ.sProcessId == 1) {
            return updateRecentNoteInner(colorNote);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("color_note_recently_viewed_comparator", colorNote);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_clear_color_note", bundle);
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            objArr[0] = "[updateRecentNote] call from ";
            objArr[1] = Integer.valueOf(MobileQQ.sProcessId);
            objArr[2] = ", data: ";
            if (colorNote != null) {
                str = colorNote.toString();
            } else {
                str = "null";
            }
            objArr[3] = str;
            QLog.d(TAG, 2, objArr);
        }
        return callServer.isSuccess();
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean deleteColorNote(int i3, String str, int i16) {
        return deleteColorNote(String.valueOf(i3) + str + i16, i16);
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean isColorNoteExit(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start search. key: " + str);
        }
        if (inMainProcess()) {
            IColorNoteDataService dataService = getDataService();
            if (dataService != null) {
                return inColorNoteCollection(str, dataService.getColorNotes(false));
            }
            QLog.d(TAG, 1, "[isColorNoteExist] key: ", str);
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_unikey", str);
        EIPCResult doIpcCall = doIpcCall("ColorNoteIPCServer", "cmd_query_isexists", bundle);
        if (doIpcCall != null) {
            return doIpcCall.data.getBoolean("extra_is_colornote_exists", false);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean updateColorNote(String str, String str2, Object obj, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateColorNote~~~");
        }
        if (MobileQQ.sProcessId == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateColorNote~~~ main[ uniKey = " + str + ", fieldName = " + str2 + ", fieldValue = " + obj + "]");
            }
            return updateColorNoteInner(str, str2, obj);
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_unikey", str);
        bundle.putString("extra_field_name", str2);
        if (i3 == 0) {
            bundle.putString("extra_field_value", (String) obj);
        } else if (i3 == 1) {
            bundle.putByteArray("extra_field_value", (byte[]) obj);
        }
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_update_colornote", bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("extra_update_colornote_succ", false);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateColorNote eipcResult = ");
            sb5.append(callServer == null ? "null" : Boolean.valueOf(callServer.isSuccess()));
            QLog.d(TAG, 2, sb5.toString());
        }
        return false;
    }

    public Bundle updateColorNoteState(int i3, String str, boolean z16, int i16) {
        return updateColorNoteState(String.valueOf(i3) + str + i16, z16);
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public boolean deleteColorNote(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "deleteColorNote~~~");
        }
        if (MobileQQ.sProcessId == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "deleteColorNote~~~ main key" + str);
            }
            deleteColorNoteInner(str, i3);
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_unikey", str);
        bundle.putInt("color_note_extra_type", i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_delete_colornote", bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("extra_delete_colornote_succ", false);
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("deleteColorNote eipcResult = ");
        sb5.append(callServer == null ? "null" : Boolean.valueOf(callServer.isSuccess()));
        QLog.d(TAG, 2, sb5.toString());
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.data.IColorNoteHelper
    public Bundle updateColorNoteState(String str, boolean z16) {
        ColorNote colorNote;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateColorNote~~~");
        }
        Bundle bundle = new Bundle();
        if (MobileQQ.sProcessId == 1) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateColorNote~~~ key " + str);
            }
            IColorNoteDataService dataService = getDataService();
            if (dataService != null) {
                colorNote = dataService.findColorNoteByKey(str);
            } else {
                QLog.d(TAG, 1, "[updateColorNoteState] runtimeService null, key: ", str);
                colorNote = null;
            }
            if (colorNote != null) {
                colorNote.setState(z16 ? 2 : 1);
            }
            bundle.putBoolean("extra_is_colornote_exists", colorNote != null);
            bundle.putBoolean("extra_can_add_colornote", canAddColorNoteInner());
            bundle.putBoolean("extra_after_sync_msg", ColorNoteSmallScreenUtil.i());
            AppRuntime appRuntime = getAppRuntime();
            if (appRuntime != null) {
                Point c16 = ColorNoteSmallScreenUtil.c(appRuntime);
                bundle.putInt("key_float_window_position_x", c16.x);
                bundle.putInt("key_float_window_position_y", c16.y);
                ColorNoteSmallScreenUtil.m(appRuntime.getApp(), 3, true);
            } else {
                com.tencent.qqperf.monitor.crash.catchedexception.a.b(new IllegalStateException("ColorNote AppRuntime null."));
            }
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putString("extra_unikey", str);
            bundle2.putBoolean("extra_update_colornote_state", z16);
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_update_colornote_state", bundle2);
            if (callServer != null && callServer.isSuccess()) {
                bundle = callServer.data;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "receive from ipc server: " + bundle2);
                }
            } else if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("updateColorNote eipcResult = ");
                sb5.append(callServer == null ? "null" : Boolean.valueOf(callServer.isSuccess()));
                QLog.d(TAG, 2, sb5.toString());
            }
        }
        return bundle;
    }

    public boolean isColorNoteExit(int i3, String str, int i16) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isColorNoteExit~~~ serviceType = " + i3 + ", subType = " + str);
        }
        String str2 = String.valueOf(i3) + str + i16;
        if (MobileQQ.sProcessId == 1) {
            IColorNoteDataService dataService = getDataService();
            if (dataService != null) {
                Iterator<ColorNote> it = dataService.getColorNotes(false).iterator();
                while (it.hasNext()) {
                    if (it.next().getUniKey().equals(str2)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            QLog.d(TAG, 2, "isColorNoteExit main ~~~ result = ", Boolean.valueOf(z16), ", key: ", str2);
            return z16;
        }
        Bundle bundle = new Bundle();
        bundle.putString("extra_unikey", str2);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ColorNoteIPCServer", "cmd_query_isexists", bundle);
        if (callServer != null && callServer.isSuccess()) {
            return callServer.data.getBoolean("extra_is_colornote_exists", false);
        }
        if (!QLog.isColorLevel()) {
            return false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isColorNoteExit eipcResult = ");
        sb5.append(callServer == null ? "null" : Boolean.valueOf(callServer.isSuccess()));
        QLog.d(TAG, 2, sb5.toString());
        return false;
    }
}
