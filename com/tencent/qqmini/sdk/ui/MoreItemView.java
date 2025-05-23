package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MoreItem;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MoreItemView extends LinearLayout {
    private static final String TAG = "MoreItemView";
    private MoreItem mMoreItem;
    private ImageView mMoreItemImage;
    private TextView mMoreItemText;

    public MoreItemView(Context context) {
        super(context);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), R.layout.mini_sdk_more_item_view, this);
        this.mMoreItemImage = (ImageView) inflate.findViewById(R.id.more_item_image);
        this.mMoreItemText = (TextView) inflate.findViewById(R.id.more_item_text);
    }

    public void bind(MoreItem moreItem) {
        int i3;
        if (moreItem == null) {
            QMLog.w(TAG, "bind. Failed to bind data. MoreItem is null");
            return;
        }
        if (moreItem.drawable != 0 && moreItem.text != null) {
            this.mMoreItem = moreItem;
            this.mMoreItemImage.setImageDrawable(getResources().getDrawable(moreItem.drawable));
            this.mMoreItemText.setText(moreItem.text);
            if (moreItem.visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            setVisibility(i3);
            return;
        }
        QMLog.w(TAG, "bind. Failed to bind data. MoreItem is null");
    }

    public MoreItem getMoreItem() {
        return this.mMoreItem;
    }
}
