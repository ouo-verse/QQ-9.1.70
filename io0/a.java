package io0;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter;
import com.tencent.guild.aio.input.at.utils.d;
import com.tencent.mobileqq.guild.util.HashTagViewType;
import com.tencent.mobileqq.guild.util.bj;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a implements GuildHashtagListAdapter.b {

    /* renamed from: a, reason: collision with root package name */
    private ho0.a f408094a;

    /* renamed from: b, reason: collision with root package name */
    private Context f408095b;

    /* renamed from: c, reason: collision with root package name */
    private EditText f408096c;

    public a(ho0.a aVar, Context context, EditText editText) {
        this.f408094a = aVar;
        this.f408095b = context;
        this.f408096c = editText;
    }

    private void b(String str, String str2, HashTagViewType hashTagViewType) {
        SpannableString v3 = d.v(this.f408095b, str, bj.a(str2, hashTagViewType), this.f408096c, 0, false, true, hashTagViewType.getValue());
        if (TextUtils.isEmpty(v3)) {
            return;
        }
        ko0.a.a(this.f408096c.getEditableText(), this.f408096c.getSelectionStart(), v3);
    }

    private void c() {
        EditText editText;
        InputMethodManager inputMethodManager = (InputMethodManager) this.f408095b.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager != null && (editText = this.f408096c) != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter.b
    public void a(String str, String str2, HashTagViewType hashTagViewType) {
        b(str, str2, hashTagViewType);
        ho0.a aVar = this.f408094a;
        if (aVar != null) {
            aVar.dismissPanel();
        }
        c();
    }
}
