package com.tencent.mobileqq.zplan.emoticon.panel.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "path", "", "id", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanEmoticonItemView$refreshView$1 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ ZPlanActionInfo $data;
    final /* synthetic */ ZPlanEmoticonItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonItemView$refreshView$1(ZPlanEmoticonItemView zPlanEmoticonItemView, ZPlanActionInfo zPlanActionInfo) {
        super(2);
        this.this$0 = zPlanEmoticonItemView;
        this.$data = zPlanActionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanEmoticonItemView this$0, ZPlanActionInfo data) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        str = this$0.localIconPath;
        if (str == null || str.length() == 0) {
            this$0.E(data);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num) {
        invoke(str, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, int i3) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        String str2;
        Drawable y16;
        ImageView imageView;
        String str3;
        ZPlanActionInfo w3 = this.this$0.w();
        if (w3 != null && i3 == w3.getId()) {
            this.this$0.localIconPath = str;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            ZPlanEmoticonItemView zPlanEmoticonItemView = this.this$0;
            obtain.mUseSharpPAnimImage = true;
            gradientDrawable = zPlanEmoticonItemView.defaultDrawable;
            obtain.mLoadingDrawable = gradientDrawable;
            gradientDrawable2 = zPlanEmoticonItemView.defaultDrawable;
            obtain.mFailedDrawable = gradientDrawable2;
            bb bbVar = bb.f335811a;
            AppRuntime d16 = bbVar.d();
            int o16 = bbVar.o(d16 != null ? d16.getCurrentUin() : null);
            str2 = this.this$0.localIconPath;
            if (!(str2 == null || str2.length() == 0)) {
                this.this$0.emotionStatus = 3;
                str3 = this.this$0.localIconPath;
                y16 = URLDrawable.getFileDrawable(str3, obtain);
            } else {
                y16 = o16 == 1 ? this.this$0.y(this.$data.getMaleDefaultUrl(), obtain) : this.this$0.y(this.$data.getFemaleDefaultUrl(), obtain);
            }
            imageView = this.this$0.icon;
            imageView.setImageDrawable(y16);
            final ZPlanEmoticonItemView zPlanEmoticonItemView2 = this.this$0;
            final ZPlanActionInfo zPlanActionInfo = this.$data;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanEmoticonItemView$refreshView$1.b(ZPlanEmoticonItemView.this, zPlanActionInfo);
                }
            }, 16, null, true);
        }
    }
}
