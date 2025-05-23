package com.tencent.sqshow.zootopia.publish;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.utils.UEDownloadSource;
import com.tencent.mobileqq.zplan.utils.ab;
import com.tencent.sqshow.zootopia.ZootopiaTransparentActivity;
import com.tencent.sqshow.zootopia.publish.frag.SelectPublishContentFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/ZPlanPublishApiImpl;", "Lcom/tencent/sqshow/zootopia/publish/a;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "publishSource", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPublishApiImpl implements a {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanPublishApiImpl f372397a = new ZPlanPublishApiImpl();

    ZPlanPublishApiImpl() {
    }

    @Override // com.tencent.sqshow.zootopia.publish.a
    public void a(final Context context, final ZootopiaSource source, final String publishSource, final Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(publishSource, "publishSource");
        ab.a(context, UEDownloadSource.SameStyle, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.publish.ZPlanPublishApiImpl$openSelectContentPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Bundle bundle2 = bundle;
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putString("key_entrance_source", publishSource);
                bundle2.putBoolean("key_need_gesture_back", false);
                ZootopiaTransparentActivity.f369904g0.a(context, SelectPublishContentFragment.class, source, bundle2);
                Context context2 = context;
                Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
                if (activity != null) {
                    activity.overridePendingTransition(R.anim.f154373ju, 0);
                }
            }
        });
    }
}
