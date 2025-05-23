package com.tencent.biz.pubaccount.weishi.comment;

import android.os.Parcelable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static Editable.Factory f80563g = new a();

    /* renamed from: a, reason: collision with root package name */
    private ViewGroup f80564a;

    /* renamed from: b, reason: collision with root package name */
    private IEmoticonMainPanel f80565b;

    /* renamed from: c, reason: collision with root package name */
    private ImageButton f80566c;

    /* renamed from: d, reason: collision with root package name */
    private EditText f80567d;

    /* renamed from: e, reason: collision with root package name */
    private BaseActivity f80568e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f80569f = false;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Editable.Factory {
        a() {
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            if (charSequence instanceof QQTextBuilder) {
                return (Editable) charSequence;
            }
            return new QQTextBuilder(charSequence, 3, 20);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.weishi.comment.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0821b extends o {
        C0821b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (b.this.f80567d != null) {
                TextUtils.backspace(b.this.f80567d);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            b.this.f(emoticonInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.f80565b.deleteEmoticonClick();
        }
    }

    private ImageButton d(RelativeLayout relativeLayout, boolean z16) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        ImageButton imageButton = new ImageButton(relativeLayout.getContext());
        imageButton.setBackgroundResource(R.drawable.lol);
        imageButton.setVisibility(z16 ? 8 : 0);
        layoutParams.rightMargin = ViewUtils.dip2px(5.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(7.0f);
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        relativeLayout.addView(imageButton, layoutParams);
        return imageButton;
    }

    private IEmoticonMainPanel e(BaseActivity baseActivity, ViewGroup viewGroup, EditText editText, int i3, EmoticonCallback emoticonCallback) {
        editText.setEditableFactory(f80563g);
        com.tencent.devicelib.a.a(baseActivity, editText);
        IEmoticonMainPanel iEmoticonMainPanel = this.f80565b;
        if (iEmoticonMainPanel != null) {
            return iEmoticonMainPanel;
        }
        IEmoticonMainPanel create = ((IEmoticonMainPanelService) baseActivity.app.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(baseActivity, 1008).setCallBack(emoticonCallback).setOnlySysAndEmoji(true).setToastOffset(baseActivity.getTitleBarHeight()).create();
        create.hideAllTabs();
        create.setOnlySysEmotionEnable(true);
        viewGroup.addView(create.getView(), new RelativeLayout.LayoutParams(-1, i3));
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(EmoticonInfo emoticonInfo) {
        EditText editText;
        String emojiString;
        if (!(emoticonInfo instanceof SystemAndEmojiEmoticonInfo) || (editText = this.f80567d) == null) {
            return;
        }
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = this.f80567d.getSelectionEnd();
        int i3 = systemAndEmojiEmoticonInfo.emotionType;
        int i16 = systemAndEmojiEmoticonInfo.code;
        if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart || i16 == -1) {
            return;
        }
        try {
            if (i3 == 1) {
                emojiString = TextUtils.getSysEmotcationString(i16);
            } else {
                emojiString = TextUtils.getEmojiString(i16);
            }
            this.f80567d.getEditableText().replace(selectionStart, selectionEnd, emojiString);
        } catch (IllegalArgumentException e16) {
            QLog.e("WSCommentEmoController", 2, "sendEmoticon: ", e16);
        }
        systemAndEmojiEmoticonInfo.addToCommonUsed(this.f80568e.app, (Parcelable) null);
    }

    public boolean i() {
        return this.f80569f;
    }

    public void k() {
        ImageButton imageButton = this.f80566c;
        if (imageButton != null) {
            imageButton.setVisibility(android.text.TextUtils.isEmpty(this.f80567d.getText()) ? 8 : 0);
        }
    }

    public void l(int i3) {
        IEmoticonMainPanel iEmoticonMainPanel = this.f80565b;
        if (iEmoticonMainPanel == null || iEmoticonMainPanel.getView().getHeight() == i3) {
            return;
        }
        this.f80565b.getView().getLayoutParams().height = i3;
        this.f80565b.getView().invalidate();
    }

    public void g() {
        this.f80569f = false;
        ViewGroup viewGroup = this.f80564a;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public void j() {
        this.f80569f = true;
        ViewGroup viewGroup = this.f80564a;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
    }

    public void h(BaseActivity baseActivity, ViewGroup viewGroup, EditText editText, int i3) {
        if (editText == null || viewGroup == null || baseActivity == null) {
            return;
        }
        this.f80568e = baseActivity;
        this.f80564a = viewGroup;
        this.f80567d = editText;
        IEmoticonMainPanel e16 = e(baseActivity, viewGroup, editText, i3, new C0821b());
        this.f80565b = e16;
        ImageButton d16 = d(e16.getView(), android.text.TextUtils.isEmpty(this.f80567d.getText()));
        this.f80566c = d16;
        d16.setOnClickListener(new c());
    }
}
