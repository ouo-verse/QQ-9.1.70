package ca3;

import android.app.Activity;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAEPath;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lca3/a;", "Lz93/a;", "Landroid/content/Intent;", "intent", "", "c", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "alreadySelectedMediaCount", "requestCode", "b", "getCameraMaterialUnZipDownload", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements z93.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ArrayList<String> f30523b;

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("key_template_asset", "aigc_security", QQWinkTempConstants.MAGIC_STUDIO_PROMPT, "aigc_pic", QQWinkTempConstants.FROM_MAGIC_STUDIO, "xsj_operation_activity_id", QQWinkTempConstants.FROM_MAGIC_STUDIO, QQWinkTempConstants.MAGIC_STUDIO_STYLE_NAME, QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE, QQWinkTempConstants.MAIGC_STUDIO_PUBLISH_TRANS, QQWinkTempConstants.MAGIC_STUDIO_COVER_INDEX);
        f30523b = arrayListOf;
    }

    private final boolean c(Intent intent) {
        if (intent == null || !intent.getBooleanExtra(QQWinkConstants.IS_QZONE_AUTO_TEMPLATE, false)) {
            return false;
        }
        return true;
    }

    @Override // z93.a
    @Nullable
    public Map<String, String> a(@Nullable Intent intent, @NotNull WinkEditorViewModel winkEditorViewModel) {
        Map<String, String> map;
        Pair pair;
        Intrinsics.checkNotNullParameter(winkEditorViewModel, "winkEditorViewModel");
        if (intent == null || !winkEditorViewModel.getIsFromMagicStudio()) {
            return null;
        }
        ArrayList<String> arrayList = f30523b;
        ArrayList arrayList2 = new ArrayList();
        for (String str : arrayList) {
            String stringExtra = intent.getStringExtra(str);
            if (stringExtra != null) {
                pair = TuplesKt.to(str, stringExtra);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList2.add(pair);
            }
        }
        map = MapsKt__MapsKt.toMap(arrayList2);
        return map;
    }

    @Override // z93.a
    public boolean b(@NotNull Activity activity, @NotNull Intent intent, int alreadySelectedMediaCount, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (c(intent)) {
            intent.putExtra(QQWinkConstants.KEY_IS_FROM_CLIP, true);
            com.tencent.mobileqq.wink.picker.f.f324854a.j(activity, intent, alreadySelectedMediaCount, new ArrayList(), requestCode);
            return true;
        }
        return false;
    }

    @Override // z93.a
    @NotNull
    public String getCameraMaterialUnZipDownload() {
        String cameraMaterialUnZipDownload = ((IAEPath) QRoute.api(IAEPath.class)).getCameraMaterialUnZipDownload();
        Intrinsics.checkNotNullExpressionValue(cameraMaterialUnZipDownload, "api(IAEPath::class.java)\u2026meraMaterialUnZipDownload");
        return cameraMaterialUnZipDownload;
    }
}
