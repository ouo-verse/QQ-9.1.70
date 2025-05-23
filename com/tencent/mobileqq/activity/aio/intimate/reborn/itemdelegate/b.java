package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import j61.IntimateBaseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/b;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/IntimateCompatBaseItemDelegate;", "Lj61/a;", "model", "", "b", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/view/ViewGroup$MarginLayoutParams;", "i", "Landroid/view/View;", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends IntimateCompatBaseItemDelegate {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
        Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderConfigData");
        if (((com.tencent.mobileqq.activity.aio.intimate.header.h) loadConfig).getNovelGroupTitle().length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    public View d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("intimate_aio_rightframe_game_8970_config");
        Intrinsics.checkNotNull(loadConfig, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.intimate.header.IntimateHeaderConfigData");
        String novelGroupTitle = ((com.tencent.mobileqq.activity.aio.intimate.header.h) loadConfig).getNovelGroupTitle();
        TextView textView = new TextView(context);
        textView.setText(novelGroupTitle);
        textView.setTextSize(14.0f);
        textView.setTypeface(null, 1);
        textView.setTextColor(context.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
        return textView;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @Nullable
    protected Drawable h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    protected ViewGroup.MarginLayoutParams i() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.leftMargin = ViewUtils.dpToPx(36.0f);
        marginLayoutParams.rightMargin = ViewUtils.dpToPx(36.0f);
        marginLayoutParams.bottomMargin = e();
        return marginLayoutParams;
    }
}
