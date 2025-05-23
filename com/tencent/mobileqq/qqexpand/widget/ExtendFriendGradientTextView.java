package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.qqexpand.profilecard.ProfileCardExtendFriendView;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExtendFriendGradientTextView extends ETTextView {
    public String O0;
    public String P0;
    public boolean Q0;
    int R0;
    ProfileCardExtendFriendView S0;
    int T0;
    boolean U0;

    public ExtendFriendGradientTextView(Context context) {
        super(context);
        this.O0 = null;
        this.P0 = null;
        this.Q0 = false;
        this.R0 = 10;
        this.T0 = 0;
        this.U0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.etrump.mixlayout.ETTextView, com.tencent.mobileqq.widget.AnimationTextView, android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (I() != null && I().r() > this.R0 && I().v(0) != null) {
            this.T0 = this.R0 * I().v(0).length;
            setShowMoreButton(true);
        } else {
            if (getLayout() == null || getLayout().getLineCount() <= this.R0) {
                return;
            }
            this.T0 = getLayout().getLineStart(this.R0);
            setShowMoreButton(true);
        }
    }

    public void setCardView(ProfileCardExtendFriendView profileCardExtendFriendView) {
        this.S0 = profileCardExtendFriendView;
    }

    public void setContent(String str) {
        String str2 = this.O0;
        if (str2 == null) {
            str2 = "";
        }
        this.O0 = str2;
        if (str == null || str2.equals(str)) {
            return;
        }
        this.O0 = str;
        String str3 = this.P0;
        if (str3 != null && this.U0) {
            setETContent(str3);
        } else {
            setETContent(str);
        }
    }

    public void setETContent(String str) {
        super.setTextMsg(str);
        setTextSize(1, 16.0f);
    }

    public void setFold(boolean z16) {
        this.U0 = z16;
        if (z16) {
            String str = this.P0;
            if (str == null) {
                str = this.O0;
            }
            setETContent(str);
            return;
        }
        setETContent(this.O0);
    }

    public void setShowMoreButton(boolean z16) {
        if (z16 != this.Q0) {
            this.Q0 = z16;
            this.P0 = this.O0.substring(0, this.T0);
            this.S0.y(z16);
            setETContent(this.P0);
        }
    }

    public ExtendFriendGradientTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O0 = null;
        this.P0 = null;
        this.Q0 = false;
        this.R0 = 10;
        this.T0 = 0;
        this.U0 = true;
    }

    public ExtendFriendGradientTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.O0 = null;
        this.P0 = null;
        this.Q0 = false;
        this.R0 = 10;
        this.T0 = 0;
        this.U0 = true;
    }
}
