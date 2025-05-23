package com.tencent.mobileqq.widget.search;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultSearchLayoutExt extends BaseSearchBarLayoutExt {
    private static final String TAG = "DefaultSearchLayoutExt";
    private b clickAction;
    protected ImageView mIconIv;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QLog.i(DefaultSearchLayoutExt.TAG, 1, "Left ImageView clicked");
            DefaultSearchLayoutExt.a(DefaultSearchLayoutExt.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    interface b {
    }

    public DefaultSearchLayoutExt(@NonNull QUISearchBar qUISearchBar) {
        super(qUISearchBar);
    }

    static /* bridge */ /* synthetic */ b a(DefaultSearchLayoutExt defaultSearchLayoutExt) {
        defaultSearchLayoutExt.getClass();
        return null;
    }

    private void updateIcon(@NonNull ImageView imageView, int i3) {
        imageView.setImageDrawable(this.mBar.getCustomResource().getSearchIcon(this.mBar));
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public int getLayoutWidthInPx(int i3) {
        return ViewUtils.dpToPx(18.0f) + getLeftMargin(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLeftMargin(int i3) {
        float f16;
        if (i3 == 4) {
            f16 = 16.0f;
        } else {
            f16 = 10.0f;
        }
        return ViewUtils.dpToPx(f16);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        return false;
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onInitLeftView(@NonNull FrameLayout frameLayout, int i3, int i16, int i17) {
        ImageView imageView = new ImageView(this.mBar.getContext());
        updateIcon(imageView, i16);
        int dpToPx = ViewUtils.dpToPx(18.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, 16);
        layoutParams.leftMargin = getLeftMargin(i3);
        frameLayout.addView(imageView, layoutParams);
        this.mIconIv = imageView;
        imageView.setOnClickListener(new a());
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onUpdateLayout(int i3) {
        ImageView imageView = this.mIconIv;
        if (imageView == null) {
            return;
        }
        ((ViewGroup.MarginLayoutParams) imageView.getLayoutParams()).leftMargin = getLeftMargin(i3);
    }

    @Override // com.tencent.mobileqq.widget.search.BaseSearchBarLayoutExt
    public void onUpdateTheme(int i3, int i16) {
        ImageView imageView = this.mIconIv;
        if (imageView == null) {
            return;
        }
        updateIcon(imageView, i3);
    }

    public void setClickAction(b bVar) {
    }
}
