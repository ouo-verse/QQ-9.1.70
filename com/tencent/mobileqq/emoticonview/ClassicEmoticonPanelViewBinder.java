package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* loaded from: classes12.dex */
public class ClassicEmoticonPanelViewBinder extends EmoticonPanelViewBinder {
    static IPatchRedirector $redirector_ = null;
    public static final int INIT_PAGE = 9;
    private static final String LOG_TAG = "ClassicEmoticonPanelViewBinder";
    private static final int NUM_COLUMN = 7;
    private static final int NUM_ROW = 3;
    private EmoticonLinearLayout.EmoticonAdapter adapter;
    private EmoticonCallback callback;
    private final SystemAndEmojiEmoticonInfo.EmoticonInfoList emoticonList;
    private final List<EmoticonInfo> panelData;

    public ClassicEmoticonPanelViewBinder(Context context, EmoticonCallback emoticonCallback, int i3) {
        super(context, 7, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, emoticonCallback, Integer.valueOf(i3));
            return;
        }
        this.callback = emoticonCallback;
        SystemAndEmojiEmoticonInfo.EmoticonInfoList oldEmoticonList = SystemAndEmojiEmoticonInfo.getOldEmoticonList(SystemEmoticonInfo.getSysEmotionOrder());
        this.emoticonList = oldEmoticonList;
        this.panelData = oldEmoticonList.emoticons;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return SystemAndEmojiEmoticonInfo.getPageCount(this.emoticonList.emoticons.size());
    }

    public int getSystemPageCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return SystemAndEmojiEmoticonInfo.getPageCount(this.emoticonList.sysEmoticonCount);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
    protected void updatePanelView(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, i3);
            return;
        }
        if (view == null) {
            return;
        }
        int emoticonPanelViewType = getEmoticonPanelViewType(i3);
        if (i3 < getPanelPageCount() && emoticonPanelViewType == 2007) {
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
            this.adapter.setRowColumnNum(3, 7);
            this.adapter.setPage(i3);
            this.adapter.setList(this.panelData);
            this.adapter.notifyDataChanged();
        }
    }
}
