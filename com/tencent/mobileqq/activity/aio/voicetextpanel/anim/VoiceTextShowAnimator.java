package com.tencent.mobileqq.activity.aio.voicetextpanel.anim;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VoiceTextShowAnimator {

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f180145h = {".", "..", MiniBoxNoticeInfo.APPNAME_SUFFIX};

    /* renamed from: a, reason: collision with root package name */
    private Timer f180146a;

    /* renamed from: b, reason: collision with root package name */
    private int f180147b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f180148c = ".";

    /* renamed from: d, reason: collision with root package name */
    private String f180149d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f180150e;

    /* renamed from: f, reason: collision with root package name */
    private int f180151f;

    /* renamed from: g, reason: collision with root package name */
    private a f180152g;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a();
    }

    private SpannableString i(@ColorInt int i3) {
        int i16;
        SpannableString spannableString = new SpannableString(this.f180150e);
        if (this.f180149d.length() > 4) {
            i16 = 3;
        } else {
            i16 = 1;
        }
        int length = this.f180149d.length() - i16;
        if (length < 0) {
            length = 0;
        }
        spannableString.setSpan(new ForegroundColorSpan(i3), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(this.f180151f), length, this.f180150e.length(), 33);
        return spannableString;
    }

    public SpannableString f() {
        SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.viu) + this.f180148c);
        spannableString.setSpan(new ForegroundColorSpan(this.f180151f), 0, spannableString.length(), 33);
        return spannableString;
    }

    public SpannableString g(String str, boolean z16) {
        String str2;
        int parseColor;
        if (str.length() - this.f180149d.length() < 3) {
            this.f180149d = str;
        } else {
            this.f180149d = str.substring(0, (this.f180149d.length() + 3) - 1);
        }
        this.f180150e = this.f180149d + this.f180148c;
        if (z16) {
            parseColor = -1;
        } else {
            if (QQTheme.isNowThemeIsNight()) {
                str2 = "#777777";
            } else {
                str2 = "#03081a";
            }
            parseColor = Color.parseColor(str2);
        }
        return i(parseColor);
    }

    public int h() {
        return this.f180150e.length();
    }

    public void j(@ColorInt int i3, a aVar) {
        this.f180151f = i3;
        this.f180146a = new BaseTimer();
        this.f180152g = aVar;
    }

    public void k() {
        this.f180146a.schedule(new TimerTask() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                VoiceTextShowAnimator voiceTextShowAnimator = VoiceTextShowAnimator.this;
                int i3 = voiceTextShowAnimator.f180147b;
                voiceTextShowAnimator.f180147b = i3 + 1;
                int length = (i3 / VoiceTextShowAnimator.f180145h.length) % VoiceTextShowAnimator.f180145h.length;
                VoiceTextShowAnimator.this.f180148c = VoiceTextShowAnimator.f180145h[length];
                if (VoiceTextShowAnimator.this.f180152g != null) {
                    VoiceTextShowAnimator.this.f180152g.a();
                }
            }
        }, 0L, 100L);
    }

    public boolean l(String str) {
        if (str.length() - this.f180149d.length() < 3) {
            return true;
        }
        return false;
    }

    public void m() {
        Timer timer = this.f180146a;
        if (timer != null) {
            timer.cancel();
            this.f180146a = null;
        }
        this.f180147b = 0;
        this.f180149d = "";
        this.f180150e = "";
        this.f180148c = "";
    }
}
