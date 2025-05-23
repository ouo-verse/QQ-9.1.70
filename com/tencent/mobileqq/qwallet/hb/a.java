package com.tencent.mobileqq.qwallet.hb;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.AnimationView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f277200a;

    /* renamed from: b, reason: collision with root package name */
    private AnimationView f277201b;

    /* renamed from: c, reason: collision with root package name */
    private AnimationView.AnimationInfo f277202c;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private class b extends AsyncTask<String, Void, AnimationView.AnimationInfo> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimationView.AnimationInfo doInBackground(String... strArr) {
            if ("1".equals(strArr[1])) {
                return AnimationView.AnimationInfo.loadFromZip(strArr[0]);
            }
            return AnimationView.AnimationInfo.loadFromFolder(strArr[0]);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(AnimationView.AnimationInfo animationInfo) {
            if (QLog.isColorLevel()) {
                QLog.i("FrameAnimHelper", 2, "task over info = " + animationInfo);
            }
            a.this.a(animationInfo);
        }
    }

    public a(Context context, LinearLayout linearLayout, int i3, boolean z16, AnimationView.MyAnimationListener myAnimationListener) {
        this.f277200a = linearLayout;
        AnimationView animationView = new AnimationView(context);
        this.f277201b = animationView;
        animationView.setmRadius(i3, z16);
        this.f277201b.setAnimationListener(myAnimationListener);
        this.f277200a.addView(this.f277201b, new LinearLayout.LayoutParams(-1, -1));
    }

    public void a(AnimationView.AnimationInfo animationInfo) {
        AnimationView animationView = this.f277201b;
        this.f277202c = animationInfo;
        animationView.setAnimationFromInfo(animationInfo);
        this.f277201b.play();
    }

    public void b(String str, boolean z16) {
        String str2;
        if (QLog.isColorLevel()) {
            QLog.i("FrameAnimHelper", 2, "task in thread runs isFolder = " + z16);
        }
        b bVar = new b();
        String[] strArr = new String[2];
        strArr[0] = str;
        if (z16) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        strArr[1] = str2;
        bVar.execute(strArr);
    }

    public void c() {
        if (QLog.isColorLevel()) {
            QLog.i("FrameAnimHelper", 2, "anim stoped...");
        }
        this.f277201b.stop();
        this.f277201b.setImageDrawable(null);
        AnimationView.AnimationInfo animationInfo = this.f277202c;
        if (animationInfo != null) {
            animationInfo.destoryBitmaps();
            this.f277202c = null;
        }
    }
}
