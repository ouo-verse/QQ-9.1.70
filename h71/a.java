package h71;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PluginData;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/activity/photo/albumlogicImp/PluginData;", "a", "base_proj_ext_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final PluginData a(Intent intent) {
        if (intent == null) {
            return null;
        }
        String valueOf = String.valueOf(intent.getStringExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME));
        String valueOf2 = String.valueOf(intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME));
        String valueOf3 = String.valueOf(intent.getStringExtra("PhotoConst.PLUGIN_NAME"));
        String valueOf4 = String.valueOf(intent.getStringExtra("PhotoConst.PLUGIN_APK"));
        String valueOf5 = String.valueOf(intent.getStringExtra("PhotoConst.UIN"));
        if (TextUtils.isEmpty(valueOf) || TextUtils.isEmpty(valueOf2)) {
            valueOf = String.valueOf(intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"));
            valueOf2 = String.valueOf(intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
        }
        String str = valueOf;
        String str2 = valueOf2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("getPluginIntent packageName=%s className=%s pluginName=%s pluginApk=%s", Arrays.copyOf(new Object[]{str, str2, valueOf3, valueOf4}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.d("AlbumLogicUtil", 2, format);
        return new PluginData(str, str2, valueOf3, valueOf4, valueOf5);
    }
}
