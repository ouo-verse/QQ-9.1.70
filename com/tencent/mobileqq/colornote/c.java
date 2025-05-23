package com.tencent.mobileqq.colornote;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends QIPCModule implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private static c f201387d;

    c() {
        super("ColorNoteIPCServer");
    }

    private IColorNoteHelper j() {
        return (IColorNoteHelper) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all");
    }

    public static c k() {
        if (f201387d == null) {
            synchronized (c.class) {
                if (f201387d == null) {
                    f201387d = new c();
                }
            }
        }
        return f201387d;
    }

    EIPCResult b(Bundle bundle) {
        boolean addColorNote = j().addColorNote(bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_add_colornote_succ", addColorNote);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult c(Bundle bundle) {
        boolean updateRecentNote = j().updateRecentNote((ColorNote) bundle.getSerializable("color_note_recently_viewed_comparator"));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("color_note_clear_succ", updateRecentNote);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult d(Bundle bundle) {
        int i3 = bundle.getInt("color_note_service_type");
        boolean detectCacheFull = ((IColorNoteController) QRoute.api(IColorNoteController.class)).detectCacheFull(BaseApplicationImpl.getApplication().getRuntime(), i3);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_clear_history_succ", detectCacheFull);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult e(Bundle bundle) {
        boolean deleteColorNote = j().deleteColorNote(bundle.getString("extra_unikey"), bundle.getInt("color_note_extra_type"));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_delete_colornote_succ", deleteColorNote);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult f(Bundle bundle) {
        boolean canAddColorNote = j().canAddColorNote();
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_can_add_colornote", canAddColorNote);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult g(Bundle bundle) {
        boolean isColorNoteExit = j().isColorNoteExit(bundle.getString("extra_unikey"));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_is_colornote_exists", isColorNoteExit);
        return EIPCResult.createResult(0, bundle2);
    }

    EIPCResult h(Bundle bundle) {
        boolean updateColorNote = j().updateColorNote(bundle.getString("extra_unikey"), bundle.getString("extra_field_name"), bundle.getString("extra_field_value"), bundle.getInt("extra_field_type"));
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_update_colornote_succ", updateColorNote);
        return EIPCResult.createResult(0, bundle2);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    EIPCResult i(Bundle bundle) {
        return EIPCResult.createResult(0, j().updateColorNoteState(bundle.getString("extra_unikey"), bundle.getBoolean("extra_update_colornote_state")));
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equalsIgnoreCase("cmd_query_isexists")) {
                return g(bundle);
            }
            if (str.equalsIgnoreCase("cmd_add_colornote")) {
                return b(bundle);
            }
            if (str.equalsIgnoreCase("cmd_delete_colornote")) {
                return e(bundle);
            }
            if (str.equalsIgnoreCase("cmd_can_add_colornote")) {
                return f(bundle);
            }
            if (str.equalsIgnoreCase("cmd_update_colornote_state")) {
                return i(bundle);
            }
            if (str.equalsIgnoreCase("cmd_update_colornote")) {
                return h(bundle);
            }
            if (str.equalsIgnoreCase("cmd_clear_color_note")) {
                return c(bundle);
            }
            if (str.equalsIgnoreCase("cmd_clear_history_color_notes")) {
                return d(bundle);
            }
        }
        return null;
    }
}
