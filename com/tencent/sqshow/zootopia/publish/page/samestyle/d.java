package com.tencent.sqshow.zootopia.publish.page.samestyle;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateCat;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateGridFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B-\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/samestyle/d;", "Luc4/a;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateGridFragment;", "", "g", "", "position", "Landroidx/fragment/app/Fragment;", "getItem", "data", h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "i", "Ljava/lang/String;", "getFrom", "()Ljava/lang/String;", "from", "Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/os/Bundle;", "getExtraParams", "()Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Ljava/lang/String;Landroidx/fragment/app/FragmentManager;Landroid/os/Bundle;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d extends uc4.a<Long, ZPlanTemplateCat, ZPlanTemplateGridFragment> {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String from;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Bundle extraParams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ZootopiaSource source, @SameStyleContentPageFrom String from, FragmentManager fm5, Bundle bundle) {
        super(fm5);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.source = source;
        this.from = from;
        this.extraParams = bundle;
    }

    @Override // uc4.a
    public String g() {
        return "SameStylePageAdapter";
    }

    @Override // uc4.a, androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        Fragment item = super.getItem(position);
        ZPlanTemplateCat zPlanTemplateCat = e().get(position);
        Intrinsics.checkNotNullExpressionValue(zPlanTemplateCat, "mDataList[position]");
        ZPlanTemplateCat zPlanTemplateCat2 = zPlanTemplateCat;
        ZPlanTemplateGridFragment zPlanTemplateGridFragment = item instanceof ZPlanTemplateGridFragment ? (ZPlanTemplateGridFragment) item : null;
        if (zPlanTemplateGridFragment != null) {
            zPlanTemplateGridFragment.Zh(zPlanTemplateCat2, this.from);
        }
        return item;
    }

    @Override // uc4.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ZPlanTemplateGridFragment d(ZPlanTemplateCat data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ZPlanTemplateGridFragment.Companion companion = ZPlanTemplateGridFragment.INSTANCE;
        ZootopiaSource zootopiaSource = this.source;
        String str = this.from;
        Bundle bundle = this.extraParams;
        if (bundle == null) {
            bundle = new Bundle();
        }
        return companion.a(data, zootopiaSource, str, new Bundle(bundle));
    }
}
