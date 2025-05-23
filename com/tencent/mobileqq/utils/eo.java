package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class eo {

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f307741d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.nearby.now.model.e f307742e;

        a(Context context, com.tencent.mobileqq.nearby.now.model.e eVar) {
            this.f307741d = context;
            this.f307742e = eVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent(this.f307741d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f307742e.a());
            if (QLog.isColorLevel()) {
                QLog.i("TopicHelper", 2, "mVideoData.topicInfo.getTopicJumpUrl() :" + this.f307742e.a());
            }
            this.f307741d.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#00aced"));
            textPaint.setUnderlineText(false);
        }
    }

    public static CharSequence a(Context context, com.tencent.mobileqq.nearby.now.model.e eVar, String str) {
        if (eVar != null && !TextUtils.isEmpty(eVar.b())) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("\n");
            sb5.append("#");
            sb5.append(eVar.b());
            sb5.append("#");
            SpannableString spannableString = new SpannableString(sb5.toString());
            if (QLog.isColorLevel()) {
                QLog.i("TopicHelper", 2, "topicAndDescWithLine is " + ((Object) sb5));
            }
            spannableString.setSpan(new a(context, eVar), str.length(), sb5.length(), 33);
            return spannableString;
        }
        return str;
    }
}
