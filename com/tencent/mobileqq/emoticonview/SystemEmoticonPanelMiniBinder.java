package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes12.dex */
public class SystemEmoticonPanelMiniBinder extends SystemEmoticonPanelViewBinder {
    static IPatchRedirector $redirector_ = null;
    private static final int NUM_COLUMN = 7;
    private static final int NUM_EMOJI_PAGE = 27;
    private static final int NUM_EMOJI_PAGE_HIGH = 34;
    private static final int NUM_ROW = 4;
    private static final int NUM_ROW_HIGH = 5;
    private int mNumEmojiPage;
    private int mNumRow;

    public SystemEmoticonPanelMiniBinder(Context context, EmoticonCallback emoticonCallback, int i3, boolean z16) {
        super(context, emoticonCallback, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, emoticonCallback, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.mNumRow = 4;
        this.mNumEmojiPage = 27;
        setRowNumAndPageNum(z16);
    }

    private int getPageCount(int[] iArr) {
        int length = iArr.length;
        return ((length + r0) - 1) / this.mNumEmojiPage;
    }

    private void setRowNumAndPageNum(boolean z16) {
        if (z16) {
            this.mNumRow = 5;
            this.mNumEmojiPage = 34;
        } else {
            this.mNumRow = 4;
            this.mNumEmojiPage = 27;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanelViewBinder, com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder, com.tencent.mobileqq.emoticonview.EmoticonViewBinder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.destroy();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanelViewBinder, com.tencent.mobileqq.emoticonview.EmoticonViewBinder
    public int getPanelPageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return getPageCount(this.SYS_EMOTION_ORDER);
    }

    @Override // com.tencent.mobileqq.emoticonview.SystemEmoticonPanelViewBinder
    protected void setRowColumnNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        EmoticonLinearLayout.EmoticonAdapter emoticonAdapter = this.adapter;
        if (emoticonAdapter != null) {
            emoticonAdapter.setRowColumnNum(this.mNumRow, 7);
        }
    }
}
