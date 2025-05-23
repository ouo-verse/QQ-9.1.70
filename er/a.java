package er;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    private static String a(int i3) {
        if (i3 != js.a.A.b() && i3 != js.a.C.b()) {
            return "album";
        }
        return "camera";
    }

    public static void c(int i3, Activity activity, PhotoCommonBaseData photoCommonBaseData, boolean z16) {
        if (activity == null || photoCommonBaseData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(photoCommonBaseData.selectedPhotoList);
        if (z16) {
            b(i3, photoCommonBaseData.albumName, photoCommonBaseData.albumId, activity, arrayList, photoCommonBaseData.selectedMediaInfoHashMap);
            return;
        }
        int b16 = js.a.B.b();
        if (gq.a.x(activity.getIntent())) {
            b16 = js.a.D.b();
        }
        if (i3 == 1) {
            e(activity, arrayList, photoCommonBaseData.selectedMediaInfoHashMap, b16);
        } else {
            d(activity, arrayList, photoCommonBaseData.selectedMediaInfoHashMap, b16, null);
        }
    }

    private static void b(int i3, String str, String str2, Activity activity, ArrayList<String> arrayList, HashMap<String, LocalMediaInfo> hashMap) {
        if (activity == null || arrayList == null || hashMap == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("PhotoConst.SELECTED_PATHS", arrayList);
        bundle.putString(AEEditorConstants.ALBUMNAME, str);
        bundle.putString("albumId", str2);
        bundle.putSerializable("PeakConstants.selectedMediaInfoHashMap", hashMap);
        int b16 = js.a.B.b();
        if (gq.a.x(activity.getIntent())) {
            b16 = js.a.D.b();
        }
        if (i3 == 0) {
            ar.a.e(activity, 0, bundle, b16);
        } else if (i3 == 1) {
            ar.a.e(activity, 1, bundle, b16);
        }
    }

    public static void d(Context context, ArrayList<String> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i3, HashMap<String, String> hashMap2) {
        Intent intent;
        if (context == null || arrayList == null || hashMap == null) {
            return;
        }
        Intent intent2 = new Intent();
        boolean z16 = context instanceof Activity;
        if (z16 && (intent = ((Activity) context).getIntent()) != null && intent.getExtras() != null) {
            intent2.putExtras(intent.getExtras());
        }
        intent2.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent2.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
        intent2.putExtra(PeakConstants.KEY_IMAGE_SUCAI_INFO, hashMap2);
        intent2.putExtra(AEEditorConstants.VIDEO_PHOTO_FROM, i3);
        intent2.putExtra(AEEditorConstants.KEY_AE_EDITOR_FROM_PHOTO_PICKER_TAB, a(i3));
        intent2.addFlags(268435456);
        if (z16) {
            ((Activity) context).setResult(-1, intent2);
        } else {
            ms.a.c("AEEditorJumpUtil", "sendPicToCirclePublish activity is not Activity");
        }
    }

    public static void e(Activity activity, ArrayList<String> arrayList, HashMap<String, LocalMediaInfo> hashMap, int i3) {
        if (activity == null || arrayList == null || hashMap == null) {
            return;
        }
        Intent intent = new Intent();
        Intent intent2 = activity.getIntent();
        if (intent2 != null && intent2.getExtras() != null) {
            intent.putExtras(intent2.getExtras());
        }
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra("PeakConstants.selectedMediaInfoHashMap", hashMap);
        intent.putExtra(AEEditorConstants.VIDEO_PHOTO_FROM, i3);
        intent.putExtra(AEEditorConstants.KEY_AE_EDITOR_FROM_PHOTO_PICKER_TAB, a(i3));
        intent.addFlags(268435456);
        activity.setResult(-1, intent);
    }
}
