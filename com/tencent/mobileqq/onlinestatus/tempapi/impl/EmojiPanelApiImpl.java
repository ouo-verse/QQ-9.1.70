package com.tencent.mobileqq.onlinestatus.tempapi.impl;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes16.dex */
public class EmojiPanelApiImpl implements IEmojiPanelApi {

    /* loaded from: classes16.dex */
    class a implements EmoticonCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EditText f256284d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AppRuntime f256285e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f256286f;

        a(EditText editText, AppRuntime appRuntime, Activity activity) {
            this.f256284d = editText;
            this.f256285e = appRuntime;
            this.f256286f = activity;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            TextUtils.backspace(this.f256284d);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo != null) {
                try {
                    emoticonInfo.send(this.f256285e, this.f256286f, this.f256284d, null);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* loaded from: classes16.dex */
    class b implements EmoticonListProvider {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean z16, boolean z17) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            return arrayList;
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi
    public View findAndInitEmojiPanel(@NonNull AppRuntime appRuntime, @NonNull @NotNull Activity activity, @NonNull @NotNull View view, int i3, @NonNull @NotNull EditText editText) {
        if ((activity instanceof QBaseActivity) && (appRuntime instanceof QQAppInterface)) {
            IEmoticonMainPanel iEmoticonMainPanel = (IEmoticonMainPanel) view.findViewById(i3);
            iEmoticonMainPanel.setCallBack(new a(editText, appRuntime, activity));
            iEmoticonMainPanel.setDisableGuide(true);
            iEmoticonMainPanel.setDisableMoreEmotionButton(true);
            iEmoticonMainPanel.setHasBigEmotion(false);
            iEmoticonMainPanel.setOnlySysAndEmoji(true);
            iEmoticonMainPanel.setDisableAutoDownload(true);
            iEmoticonMainPanel.init((QQAppInterface) appRuntime, 100002, activity, ((QBaseActivity) activity).getTitleBarHeight(), null, null, false, new b());
            iEmoticonMainPanel.setTabListOverScrollMode(2);
            return iEmoticonMainPanel.getView();
        }
        return null;
    }
}
