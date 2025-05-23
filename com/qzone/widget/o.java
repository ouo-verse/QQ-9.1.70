package com.qzone.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.tencent.mobileqq.R;
import com.tencent.widget.ActionSheet;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends ActionSheet {
    public o(Context context) {
        super(context);
    }

    public static o n0(Context context) {
        o oVar = new o(context);
        if (Build.VERSION.SDK_INT != 23) {
            oVar.getWindow().setWindowAnimations(R.style.f173293c);
        }
        return oVar;
    }

    @Override // com.tencent.widget.ActionSheet
    protected int getActionSheetCancelButtonLayoutId() {
        return R.layout.anf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ActionSheet
    public int getActionSheetCommonButtonLayoutId() {
        return super.getActionSheetCommonButtonLayoutId();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ActionSheet
    public int getActionSheetTitleLayoutId() {
        return super.getActionSheetTitleLayoutId();
    }

    @Override // com.tencent.widget.ActionSheet
    public Drawable getSelectorByType(int i3) {
        if (i3 != 0) {
            return this.mResources.getDrawable(R.drawable.aih);
        }
        return this.mResources.getDrawable(R.drawable.afg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.ActionSheet
    public ColorStateList getActionButtonColorByType(int i3) {
        if (i3 != 3 && i3 != 8) {
            return ColorStateList.valueOf(this.mResources.getColor(R.color.qzone_skin_feed_content_text_color));
        }
        return super.getActionButtonColorByType(i3);
    }
}
