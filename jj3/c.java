package jj3;

import android.app.Activity;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.piceditor.EditPicEntrance;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Ljj3/c;", "", "Landroid/app/Activity;", "context", "", "entranceType", "", "picPath", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f410278a = new c();

    c() {
    }

    @JvmStatic
    public static final void a(Activity context, @EditPicEntrance int entranceType, String picPath) {
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        if (context == null) {
            return;
        }
        context.startActivity(((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(context, picPath, false, false, false, false, false, 16, entranceType, 0));
    }
}
