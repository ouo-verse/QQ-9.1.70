package com.qzone.detail.ui.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends ShareActionSheetBuilder {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    protected static class a extends ShareActionSheetBuilder.b {

        /* compiled from: P */
        /* renamed from: com.qzone.detail.ui.component.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        protected static class C0384a extends ShareActionSheetBuilder.b.a {
            public C0384a(Context context) {
                super(context);
                Resources resources = context.getResources();
                this.f307305b = resources.getDrawable(R.drawable.a_4);
                this.f307306c = resources.getDrawable(R.drawable.a_g);
            }
        }

        public a(Context context, List<ShareActionSheetBuilder.ActionSheetItem> list) {
            super(context, list);
        }

        @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder.b
        protected ShareActionSheetBuilder.b.a a(Context context) {
            return new C0384a(context);
        }
    }

    public h(Context context) {
        super(context);
    }

    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder
    protected ShareActionSheetBuilder.b c(Context context, List<ShareActionSheetBuilder.ActionSheetItem> list) {
        return new a(context, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.utils.ShareActionSheetBuilder
    public View d() {
        View d16 = super.d();
        Context context = this.f307286d;
        if (context != null) {
            Resources resources = context.getResources();
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(resources.getColor(R.color.qzone_skin_more_menu_background));
            }
            TextView textView = this.E;
            if (textView != null) {
                textView.setBackgroundColor(resources.getColor(R.color.qzone_skin_feed_background_color));
                this.E.setTextColor(resources.getColor(R.color.qzone_skin_feed_content_text_color));
            }
        }
        return d16;
    }
}
