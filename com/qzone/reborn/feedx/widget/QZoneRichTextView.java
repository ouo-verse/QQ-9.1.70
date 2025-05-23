package com.qzone.reborn.feedx.widget;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.personalize.flashnickname.ui.FlashCellTextView;
import com.qzone.proxy.feedcomponent.text.DynamicImageCell;
import com.qzone.proxy.feedcomponent.text.TextCell;
import com.qzone.proxy.feedcomponent.text.TextCellLayout;
import com.qzone.proxy.feedcomponent.text.UserNameCell;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneRichTextView extends FlashCellTextView {
    protected Activity K;
    private a L;
    private boolean M;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface a {
        void onClick();
    }

    public QZoneRichTextView(Context context) {
        super(context);
        this.M = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.proxy.feedcomponent.text.CellTextView
    public void init(Context context, AttributeSet attributeSet, int i3) {
        super.init(context, attributeSet, i3);
        setLineSpace(0);
        this.K = i.c(this);
    }

    public void k(TextCell textCell) {
        if ((textCell instanceof DynamicImageCell) && textCell.getUin() != null && textCell.getUin().longValue() > 0) {
            DynamicImageCell dynamicImageCell = (DynamicImageCell) textCell;
            if (dynamicImageCell.isClickVipIcon(textCell.lastClickEvent.getX(), textCell.lastClickEvent.getY())) {
                dynamicImageCell.jumpH5Url(getContext());
                return;
            } else {
                ho.h.b(this.K, textCell.getUin().longValue());
                return;
            }
        }
        if ((textCell instanceof UserNameCell) && textCell.getUin() != null && textCell.getUin().longValue() > 0) {
            ho.h.b(this.K, textCell.getUin().longValue());
        } else {
            if (textCell == null || TextUtils.isEmpty(textCell.getUrl())) {
                return;
            }
            yo.d.d(textCell.getUrl(), getContext(), null);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.CellTextView, com.qzone.proxy.feedcomponent.text.TextLayoutBase
    public void performCellClick(TextCell textCell) {
        if (!this.M) {
            RFWLog.d("QZoneRichTextView", RFWLog.USR, "disable click, return");
            return;
        }
        if (textCell == null) {
            View.OnClickListener onClickListener = this.onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this);
                return;
            }
            return;
        }
        a aVar = this.L;
        if (aVar != null) {
            aVar.onClick();
            return;
        }
        TextCellLayout.OnCellClickListener onCellClickListener = this.onCellClickListener;
        if (onCellClickListener != null) {
            onCellClickListener.onClick(textCell, this);
        } else {
            k(textCell);
        }
    }

    public void setClickEnable(boolean z16) {
        this.M = z16;
    }

    public void setOnUrlClickListener(a aVar) {
        this.L = aVar;
    }

    public QZoneRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = true;
    }

    public QZoneRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = true;
    }
}
