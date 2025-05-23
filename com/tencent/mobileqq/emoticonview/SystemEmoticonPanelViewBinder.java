package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes12.dex */
public class SystemEmoticonPanelViewBinder extends EmoticonPanelViewBinder {
    static IPatchRedirector $redirector_ = null;
    private static final int NUM_COLUMN = 7;
    private static final int NUM_ROW = 3;
    protected int[] SYS_EMOTION_ORDER;
    protected EmoticonLinearLayout.EmoticonAdapter adapter;
    private EmoticonCallback callback;
    private List<EmoticonInfo> panelData;

    public SystemEmoticonPanelViewBinder(Context context, EmoticonCallback emoticonCallback, int i3) {
        super(context, 1, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, emoticonCallback, Integer.valueOf(i3));
            return;
        }
        this.panelData = null;
        this.callback = emoticonCallback;
        this.SYS_EMOTION_ORDER = SystemEmoticonInfo.getSysEmotionOrder();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder, com.tencent.mobileqq.emoticonview.EmoticonViewBinder
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.destroy();
            this.callback = null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
    protected int getEmoticonPanelViewType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        return 2007;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonViewBinder
    public int getPanelPageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return SystemAndEmojiEmoticonInfo.getPageCount(this.SYS_EMOTION_ORDER);
    }

    protected void setRowColumnNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        EmoticonLinearLayout.EmoticonAdapter emoticonAdapter = this.adapter;
        if (emoticonAdapter != null) {
            emoticonAdapter.setRowColumnNum(3, 7);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
    protected void updatePanelView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null || getEmoticonPanelViewType(i3) != 2007 || i3 >= getPanelPageCount()) {
            return;
        }
        if (this.panelData == null) {
            this.panelData = SystemEmoticonInfo.getEmoticonList(this.SYS_EMOTION_ORDER);
        }
        if (this.adapter == null) {
            EmoticonPanelViewBinder.DefaultEmoticonAdapter defaultEmoticonAdapter = new EmoticonPanelViewBinder.DefaultEmoticonAdapter(2007);
            this.adapter = defaultEmoticonAdapter;
            defaultEmoticonAdapter.setHasDeleteBtn(true);
            this.adapter.setHasPlusButton(false);
            this.adapter.setHasSettingButton(false);
            EmoticonInfo emoticonInfo = new EmoticonInfo();
            emoticonInfo.action = "delete";
            this.adapter.setSpecEmoticon(emoticonInfo);
        }
        EmoticonLinearLayout emoticonLinearLayout = (EmoticonLinearLayout) view;
        emoticonLinearLayout.setCallBack(this.callback);
        emoticonLinearLayout.setAdapter(this.adapter);
        setRowColumnNum();
        this.adapter.setPage(i3);
        this.adapter.setList(this.panelData);
        this.adapter.notifyDataChanged();
    }
}
