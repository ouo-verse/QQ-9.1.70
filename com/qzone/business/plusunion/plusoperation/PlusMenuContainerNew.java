package com.qzone.business.plusunion.plusoperation;

import android.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.config.AppSetting;
import com.tencent.component.media.image.ImageLoader;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class PlusMenuContainerNew extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    private View.OnClickListener f44644d;

    /* renamed from: e, reason: collision with root package name */
    private View.OnLongClickListener f44645e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44646f;

    /* renamed from: h, reason: collision with root package name */
    private Activity f44647h;

    /* renamed from: i, reason: collision with root package name */
    private String f44648i;

    /* renamed from: m, reason: collision with root package name */
    private static final HashMap<String, Drawable> f44643m = new HashMap<>();
    public static String C = "PlusOperationContainer_sp";
    public static String D = "RecomView_show_sp";

    /* loaded from: classes39.dex */
    public interface a {
    }

    public static void setDifferIcon(final String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ImageLoader.getInstance(FeedGlobalEnv.getContext()).loadImageAsync(str2, new ImageLoader.ImageLoadListener() { // from class: com.qzone.business.plusunion.plusoperation.PlusMenuContainerNew.8
            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str3, final Drawable drawable, ImageLoader.Options options) {
                QzoneHandlerThreadFactory.getMainHandler().post(new Runnable() { // from class: com.qzone.business.plusunion.plusoperation.PlusMenuContainerNew.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PlusMenuContainerNew.f44643m.put(str, drawable);
                    }
                });
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str3, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str3, ImageLoader.Options options) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str3, float f16, ImageLoader.Options options) {
            }
        }, ImageLoader.Options.obtain());
    }

    public static void setShowTemplateRedDot(String str, boolean z16, long j3, long j16) {
        QZLog.d("PlusMenuContainer", 1, "setShowTemplateRedDot, id:" + str + " show:" + z16);
        if (z16) {
            String j06 = u5.b.j0("key_show_template_reddot", null, LoginData.getInstance().getUin());
            if (TextUtils.isEmpty(j06)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("id", str);
                    jSONObject.put("show", z16);
                    jSONObject.put(AEEditorConstants.VIDEO_CLIP_START_TIME, j3);
                    jSONObject.put(AEEditorConstants.VIDEO_CLIP_END_TIME, j16);
                    u5.b.x0("key_show_template_reddot", jSONObject.toString(), LoginData.getInstance().getUin());
                    QZLog.d("PlusMenuContainer", 1, "setShowTemplateRedDot:" + jSONObject);
                    return;
                } catch (Exception e16) {
                    QZLog.e("PlusMenuContainer", 1, e16, new Object[0]);
                    return;
                }
            }
            try {
                JSONObject jSONObject2 = new JSONObject(j06);
                if (jSONObject2.optString("id", "").equals(str)) {
                    return;
                }
                jSONObject2.put("id", str);
                jSONObject2.put("show", z16);
                jSONObject2.put(AEEditorConstants.VIDEO_CLIP_START_TIME, j3);
                jSONObject2.put(AEEditorConstants.VIDEO_CLIP_END_TIME, j16);
                u5.b.x0("key_show_template_reddot", jSONObject2.toString(), LoginData.getInstance().getUin());
                QZLog.d("PlusMenuContainer", 1, "updateShowTemplateRedDot:" + jSONObject2);
                return;
            } catch (Exception e17) {
                QZLog.e("PlusMenuContainer", 1, e17, new Object[0]);
                return;
            }
        }
        u5.b.A0("key_show_template_reddot", LoginData.getInstance().getUin());
        QZLog.d("PlusMenuContainer", 1, "removeShowTemplateRedDot:");
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        Activity activity;
        super.onVisibilityChanged(view, i3);
        if (AppSetting.f99565y && (activity = this.f44647h) != null && view == this) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
            for (int i16 = 0; i16 < viewGroup.getChildCount(); i16++) {
                ViewCompat.setImportantForAccessibility(viewGroup.getChildAt(i16), i3 == 0 ? 4 : 0);
            }
            ViewCompat.setImportantForAccessibility(this, 1);
        }
    }

    public void setActivity(Activity activity, String str, com.qzone.common.activities.titlebuilder.d dVar) {
        this.f44647h = activity;
        this.f44648i = str;
    }

    public void setForceUpdate(boolean z16) {
        this.f44646f = z16;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f44644d = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f44645e = onLongClickListener;
    }

    public void setEventListener(a aVar) {
    }
}
