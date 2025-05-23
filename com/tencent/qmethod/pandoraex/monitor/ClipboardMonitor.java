package com.tencent.qmethod.pandoraex.monitor;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import androidx.annotation.RequiresApi;
import com.tencent.qmethod.pandoraex.core.MonitorReporter;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ClipboardMonitor {
    private static final String SYSTEM_CALL_CLIPBOARD = "call system api:ClipboardManager.";
    private static final String TAG = "ClipboardMonitor";

    public static void addPrimaryClipChangedListener(ClipboardManager clipboardManager, ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#AD_CLIP_LIS", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            clipboardManager.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
        }
    }

    @RequiresApi(api = 28)
    public static void clearPrimaryClip(ClipboardManager clipboardManager) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#CL_PRI_CLIP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            clipboardManager.clearPrimaryClip();
        }
    }

    public static ClipData getPrimaryClip(ClipboardManager clipboardManager) {
        if (!com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#G_PRI_DESC", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return null;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        com.tencent.qmethod.pandoraex.core.ext.netcap.k.g(primaryClip);
        return primaryClip;
    }

    public static ClipDescription getPrimaryClipDescription(ClipboardManager clipboardManager) {
        if (!com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#G_PRI_CLIP_DESC", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return null;
        }
        return clipboardManager.getPrimaryClipDescription();
    }

    public static CharSequence getText(ClipboardManager clipboardManager) {
        CharSequence charSequence = null;
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#G_TXT", new a.C11438a().b("ban").b("cache_only").d(), null)) && (charSequence = clipboardManager.getText()) != null) {
            com.tencent.qmethod.pandoraex.core.ext.netcap.k.h(charSequence);
        }
        return charSequence;
    }

    public static boolean hasPrimaryClip(ClipboardManager clipboardManager) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#HAS_PRI_CLIP", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return clipboardManager.hasPrimaryClip();
        }
        return false;
    }

    public static boolean hasText(ClipboardManager clipboardManager) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#HAS_TXT", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            return clipboardManager.hasText();
        }
        return false;
    }

    public static void removePrimaryClipChangedListener(ClipboardManager clipboardManager, ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#REM_CLIP_LIS", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
        }
    }

    public static void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#SET_PRI_CLIP#C", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            clipboardManager.setPrimaryClip(clipData);
        }
    }

    public static void setText(ClipboardManager clipboardManager, CharSequence charSequence) {
        if (com.tencent.qmethod.pandoraex.core.x.C(MonitorReporter.getStrategyAndReport("clipboard", "CM#SET_TXT", new a.C11438a().b("ban").b("cache_only").d(), null))) {
            clipboardManager.setText(charSequence);
        }
    }
}
