package k73;

import android.app.Activity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\f"}, d2 = {"Lk73/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "isLightSoLoadSucceed", "", "a", "c", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f411805a = new a();

    a() {
    }

    private final void a(Activity activity, boolean isLightSoLoadSucceed) {
        boolean equals;
        try {
            r73.a aVar = r73.a.f430927a;
            if (FileUtils.fileExists(aVar.a())) {
                String calcMd5 = FileUtils.calcMd5(aVar.a());
                equals = StringsKt__StringsJVMKt.equals("28A92E287E6EAD0CFCF7EF9E7789DB7F", calcMd5, true);
                if (!equals) {
                    b.c("WinkLightResourceUtils", "default template json md5 verify failed " + calcMd5 + ", delete current file");
                    FileUtils.deleteFile(aVar.a());
                    if (isLightSoLoadSucceed) {
                        b(activity);
                    }
                } else {
                    b.f("WinkLightResourceUtils", "default template json md5 verify success");
                }
            } else {
                b.c("WinkLightResourceUtils", "default template json not exist");
            }
        } catch (Exception e16) {
            b.d("WinkLightResourceUtils", "checkDefaultTemplateJson error", e16);
        }
    }

    public final void b(@Nullable Activity activity) {
        b.f("WinkLightResourceUtils", "lightResourceLoadFailed");
        if (activity != null) {
            QQToast.makeText(activity, R.string.f240277oq, 0).show();
            activity.finish();
        }
    }

    public final boolean c(@Nullable Activity activity) {
        b.a("WinkLightResourceUtils", "loadLightResource start");
        long currentTimeMillis = System.currentTimeMillis();
        boolean R = WinkExportUtils.R();
        a(activity, R);
        b.a("WinkLightResourceUtils", "loadLightResource end, cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return R;
    }
}
