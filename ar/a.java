package ar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.aeeditor.AEEditorActivity;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a {
    private static void f(Bundle bundle, Intent intent, String str) {
        bundle.putString(str, intent.getStringExtra(str));
        intent.putExtra(str, "");
    }

    public static boolean a(Bundle bundle) {
        return c(bundle, 0);
    }

    public static boolean b(Bundle bundle) {
        return c(bundle, 2);
    }

    public static boolean d(Bundle bundle) {
        return c(bundle, 1);
    }

    private static boolean c(Bundle bundle, int i3) {
        return bundle != null && bundle.containsKey("editorType") && bundle.getInt("editorType") == i3;
    }

    public static void e(Activity activity, int i3, Bundle bundle, int i16) {
        int i17;
        Bundle bundle2;
        if (i3 == 0) {
            i17 = 10000;
        } else if (i3 == 1) {
            i17 = 10001;
        } else {
            if (i3 != 2 && i3 != 3) {
                throw new IllegalArgumentException("wrong editor type");
            }
            i17 = 10002;
        }
        Intent intent = new Intent(activity, (Class<?>) AEEditorActivity.class);
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putInt("editorType", i3);
        bundle2.putInt("editorFrom", i16);
        if (activity.getIntent() != null) {
            Intent intent2 = activity.getIntent();
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_FILTER_ID);
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_TEXT_STICKER_ID);
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_IMAGE_TEMPLATE_ID);
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_VIDEO_TEMPLATE_ID);
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_TEXT_ID);
            f(bundle2, intent2, AEEditorConstants.AE_EDITOR_FRAME_ID);
            bundle2.putBoolean(PeakConstants.KEY_IS_CAPSULE_BUTTON, intent2.getBooleanExtra(PeakConstants.KEY_IS_CAPSULE_BUTTON, false));
        }
        intent.putExtras(bundle2);
        intent.addFlags(603979776);
        activity.startActivityForResult(intent, i17);
    }
}
