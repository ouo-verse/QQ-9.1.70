package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emoticonview.EmoticonRecDressup;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BigEmotionServiceImpl implements IBigEmotionService {
    static IPatchRedirector $redirector_;

    public BigEmotionServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IBigEmotionService
    public void openEmojiDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, String str2, boolean z16, Intent intent, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            EmojiHomeUiPlugin.openEmojiDetailPage(context, iEmoticonMainPanelApp, str, 8, str2, z16, intent, z17);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, iEmoticonMainPanelApp, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), intent, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IBigEmotionService
    public void openQQBrowserWithoutAD(Context context, String str, long j3, Intent intent, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, str, Long.valueOf(j3), intent, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent2.putExtra("hide_operation_bar", true);
        VasWebviewUtil.openQQBrowserWithoutAD(context, str, -1L, intent2, false, -1);
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IBigEmotionService
    public void openEmojiDetailPage(Context context, IEmoticonMainPanelApp iEmoticonMainPanelApp, String str, int i3, String str2, boolean z16, Intent intent, boolean z17, boolean z18, int i16, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, iEmoticonMainPanelApp, str, Integer.valueOf(i3), str2, Boolean.valueOf(z16), intent, Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i16), str3);
            return;
        }
        Intent intent2 = new Intent();
        if (z18) {
            intent2.putExtra(VasWebviewConstants.KEY_TO_RECOMMEND_DRESSUP, true);
        } else {
            intent2.putExtra(VasWebviewConstants.KEY_EMOJI_IS_ORIGINAL, (i16 & 1) != 0);
            intent2.putExtra(VasWebviewConstants.KEY_AUTHOR_ID, EmoticonRecDressup.getEmotionRecommend(str3, true).authorId);
        }
        EmojiHomeUiPlugin.openEmojiDetailPage(context, iEmoticonMainPanelApp, iEmoticonMainPanelApp.getAccount(), 8, String.valueOf(str3), z16, intent2, z17);
    }
}
