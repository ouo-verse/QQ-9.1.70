package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSViewDecorationUtil;

/* loaded from: classes22.dex */
public class PTSTextView extends TextView implements IView {
    static IPatchRedirector $redirector_;
    private PTSViewDecorationUtil.RoundedCorner mRoundedCorner;

    public PTSTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mRoundedCorner = new PTSViewDecorationUtil.RoundedCorner(this);
        setTextSize(16.0f);
        setTextColor(-16777216);
        setIncludeFontPadding(false);
        setEllipsize(TextUtils.TruncateAt.END);
        getPaint().setAntiAlias(true);
        setGravity(16);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        int saveCount = this.mRoundedCorner.getSaveCount(canvas);
        super.draw(canvas);
        this.mRoundedCorner.drawCorner(canvas, saveCount);
        this.mRoundedCorner.drawBorder(canvas);
    }

    @Override // com.tencent.pts.ui.view.IView
    public void onBindNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeInfo);
        } else {
            this.mRoundedCorner.onBindNodeInfo(pTSNodeInfo);
        }
    }
}
