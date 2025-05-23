package com.tencent.qqmini.minigame.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.manager.GameVConsoleManager;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.io.File;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ExportLogFileAction implements Action<Boolean> {
    private static final String TAG = "ExportLogFileAction";

    private void a(Context context) {
        File i3 = GameVConsoleManager.i();
        if (i3 != null && i3.exists()) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".consolelogfileprovider", i3);
            intent.setType(context.getContentResolver().getType(uriForFile));
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            intent.addFlags(1);
            Intent createChooser = Intent.createChooser(intent, context.getString(R.string.mini_game_export_log_to));
            createChooser.putExtra("big_brother_source_key", "biz_src_miniapp");
            try {
                context.startActivity(createChooser);
                return;
            } catch (Exception e16) {
                QMLog.e(TAG, "share log file failed", e16);
                return;
            }
        }
        MiniToast.makeText(context, R.string.mini_game_log_file_invalid, 1).show();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        if (baseRuntime == null) {
            return Boolean.FALSE;
        }
        Activity attachActivity = baseRuntime.getAttachActivity();
        if (attachActivity == null) {
            return Boolean.FALSE;
        }
        a(attachActivity);
        return Boolean.TRUE;
    }
}
