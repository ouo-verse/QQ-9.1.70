package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.content.Context;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.biz.anonymous.a;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.text.QQText;

/* compiled from: P */
/* loaded from: classes18.dex */
public class CommentDanmakuDependImpl implements ICommentDanmakuDepend {
    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public TextView createETTextView(Context context, String str, int i3, int i16, float f16) {
        ETTextView eTTextView = new ETTextView(context);
        eTTextView.setText(new QQText(str, 3, i3));
        eTTextView.setTextColor(i16);
        eTTextView.setAlpha(f16);
        return eTTextView;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public boolean getAioAnonymousStatus(String str) {
        return a.h().d(str);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public int getAnonymousHeadId(String str) {
        a.b g16 = a.h().g(str);
        if (g16 != null) {
            return g16.f78373c;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public String getAnonymousHeadUrl(int i3) {
        return a.f(i3);
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public String getAnonymousNickName(String str) {
        a.b g16 = a.h().g(str);
        if (g16 != null) {
            return g16.f78374d;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend
    public int getChatEmotionSizeWithDP() {
        return ChatTextSizeSettingActivity.getChatEmotionSizeWithDP();
    }
}
