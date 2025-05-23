package i8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.qzone.album.util.g;
import com.qzone.preview.LocalPictureViewer;
import com.qzone.preview.QzonePictureSelectViewer;
import com.qzone.reborn.layer.part.QZoneFeedXGalleryActivity;
import com.qzone.reborn.layer.part.QZonePictureViewerFragment;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import common.config.service.QZoneConfigHelper;
import j8.c;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    Intent f407350a;

    public a b(c cVar) {
        this.f407350a.putExtras(cVar.getParams());
        return this;
    }

    public a c(c cVar) {
        this.f407350a.putExtras(cVar.getParams());
        return this;
    }

    public a d(Context context) {
        Intent intent = new Intent();
        this.f407350a = intent;
        intent.setClass(context, LocalPictureViewer.class);
        return this;
    }

    public a e(Context context) {
        Intent intent = new Intent();
        this.f407350a = intent;
        intent.setClass(context, QzonePictureSelectViewer.class);
        return this;
    }

    public a f(Context context) {
        Intent intent = new Intent();
        this.f407350a = intent;
        intent.setClass(context, QZoneFeedXGalleryActivity.class);
        this.f407350a.putExtra("public_fragment_class", QZonePictureViewerFragment.class.getName());
        return this;
    }

    public void g(Activity activity, int i3, boolean z16) {
        j(this.f407350a);
        if (i3 >= 0) {
            l(activity, this.f407350a, i3, z16);
        } else {
            k(activity, this.f407350a, z16);
        }
    }

    public a i(c cVar) {
        this.f407350a.putExtras(cVar.getParams());
        return this;
    }

    private static void k(Activity activity, Intent intent, boolean z16) {
        l(activity, intent, -1, z16);
    }

    public a a(boolean z16, int i3) {
        if (z16) {
            this.f407350a.addFlags(i3);
        }
        return this;
    }

    public a h(Intent intent) {
        if (intent != null) {
            this.f407350a.putExtras(intent);
        }
        return this;
    }

    private static void j(Intent intent) {
        if (intent != null && g.k(QZoneConfigHelper.i0(), QZoneConfigHelper.j0())) {
            intent.putExtra("preload_flag", QZoneConfigHelper.k0());
        }
    }

    private static void l(Activity activity, Intent intent, int i3, boolean z16) {
        if (activity == null) {
            return;
        }
        if (PlatformUtil.version() >= 7) {
            while (activity.getParent() != null) {
                activity = activity.getParent();
            }
            if (activity instanceof PluginProxyActivity) {
                ((PluginProxyActivity) activity).startActivityForResult(intent, i3);
            } else if (activity instanceof BasePluginActivity) {
                ((BasePluginActivity) activity).startActivityForResult(intent, i3);
            } else {
                com.qzone.feed.utils.b.e(activity, intent, i3);
            }
            if (z16) {
                activity.overridePendingTransition(R.anim.f155022gz, R.anim.f155024h1);
                return;
            } else {
                activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
                return;
            }
        }
        com.qzone.feed.utils.b.e(activity, intent, i3);
    }
}
